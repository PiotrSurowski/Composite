package pl.piotrsurowski.structure.compositeblock;

import pl.piotrsurowski.structure.block.Block;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
