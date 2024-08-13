package pl.piotrp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {

    @Test
    public void testFindBlockByColor() {
        Block block1 = new ConcreteBlock("red", "gold");
        Block block2 = new ConcreteBlock("blue", "metal");
        Block block3 = new ConcreteCompositeBlock("green", "plastic", Arrays.asList(block1, block2));
        Wall wall = new Wall(Arrays.asList(block3));

        Optional<Block> result = wall.findBlockByColor("blue");

        assertTrue(result.isPresent(), "Block with color 'blue' should be found");
        assertEquals("blue", result.get().getColor(), "Color should be 'blue'");
    }

    @Test
    public void testFindBlocksByMaterial() {
        Block block1 = new ConcreteBlock("red", "wood");
        Block block2 = new ConcreteBlock("blue", "wood");
        Block block3 = new ConcreteCompositeBlock("green", "plastic", Arrays.asList(block1, block2));
        Wall wall = new Wall(Arrays.asList(block3));

        List<Block> result = wall.findBlocksByMaterial("wood");

        assertEquals(2, result.size(), "There should be 2 blocks with material 'wood'");
        assertTrue(result.stream().allMatch(block -> "wood".equals(block.getMaterial())), "All blocks should have material 'wood'");
    }

    @Test
    public void testCount() {
        Block block1 = new ConcreteBlock("red", "wood");
        Block block2 = new ConcreteBlock("blue", "metal");
        Block block3 = new ConcreteCompositeBlock("green", "plastic", Arrays.asList(block1, block2));
        Wall wall = new Wall(Arrays.asList(block3));

        int count = wall.count();

        assertEquals(3, count, "The count should be 3");
    }
}
