package pl.piotrp;

import java.util.List;

public class ConcreteCompositeBlock implements CompositeBlock {
    private final String color;
    private final String material;
    private final List<Block> blocks;

    public ConcreteCompositeBlock(String color, String material, List<Block> blocks) {
        this.color = color;
        this.material = material;
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
