package pl.piotrp;

import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;
    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .flatMap(this::expandBlock)
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .flatMap(this::expandBlock)
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) blocks.stream()
                .flatMap(this::expandBlock)
                .count();
    }

    private Stream<Block> expandBlock(Block block) {
        if (block instanceof CompositeBlock) {
            return Stream.concat(
                    Stream.of(block),
                    ((CompositeBlock) block).getBlocks().stream().flatMap(this::expandBlock)
            );
        } else {
            return Stream.of(block);
        }
    }
}
