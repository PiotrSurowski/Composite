package pl.piotrsurowski;

import pl.piotrsurowski.structure.Structure;
import pl.piotrsurowski.structure.block.Block;

import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    @Override
    public Optional<Block> findBlockByColor(String color) {
        return Optional.empty();
    }

    @Override
    public List<Block> findBlockByMaterial(String material) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }
}
