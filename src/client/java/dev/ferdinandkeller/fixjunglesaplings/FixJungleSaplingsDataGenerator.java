package dev.ferdinandkeller.fixjunglesaplings;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.HolderLookup;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class FixJungleSaplingsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(FixJungleSaplingsBlockLootTableProvider::new);
	}
}

class FixJungleSaplingsBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected FixJungleSaplingsBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        add(
            Blocks.JUNGLE_LEAVES,
            createLeavesDrops(
                Blocks.JUNGLE_LEAVES,
                Blocks.JUNGLE_SAPLING,
                1/20f, 1/16f, 1/12f, 1/10f
            )
        );
    }
}
