package biomesoplenty.biomes;

import java.awt.Color;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.Blocks;
import biomesoplenty.configuration.BOPConfiguration;
import biomesoplenty.worldgen.WorldGenFungi;
import biomesoplenty.worldgen.WorldGenMoss;
import biomesoplenty.worldgen.WorldGenThickTree2;
import biomesoplenty.worldgen.WorldGenThickTree3;

public class BiomeGenFungiForest extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	@SuppressWarnings("unchecked")
	public BiomeGenFungiForest(int par1)
	{
		super(par1);
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		customBiomeDecorator.treesPerChunk = 8;
		customBiomeDecorator.grassPerChunk = 6;
		customBiomeDecorator.sproutsPerChunk = 2;
		customBiomeDecorator.bushesPerChunk = 2;
		customBiomeDecorator.highGrassPerChunk = 1;
		customBiomeDecorator.mushroomsPerChunk = 8;
		customBiomeDecorator.bigMushroomsPerChunk = 8;
		customBiomeDecorator.toadstoolsPerChunk = 5;
		customBiomeDecorator.portobellosPerChunk = 7;
		customBiomeDecorator.blueMilksPerChunk = 4;
		customBiomeDecorator.glowshroomsPerChunk = 2;
		customBiomeDecorator.blueFlowersPerChunk = 3;
		customBiomeDecorator.cattailsPerChunk = 1;
		customBiomeDecorator.highCattailsPerChunk = 2;
		customBiomeDecorator.reedsBOPPerChunk = 1;
		customBiomeDecorator.lilyflowersPerChunk = 2;
		customBiomeDecorator.carrotsPerChunk = 1;
		customBiomeDecorator.generateMycelium = true;
		customBiomeDecorator.generatePumpkins = true;
		waterColorMultiplier = 65326;
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 3, 4, 8));
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		WorldGenMoss var5 = new WorldGenMoss();

		for (int var6 = 0; var6 < 20; ++var6)
		{
			int var7 = par3 + par2Random.nextInt(16) + 8;
			byte var8 = 58;
			int var9 = par4 + par2Random.nextInt(16) + 8;
			var5.generate(par1World, par2Random, var7, var8, var9);
		}
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	 @Override
	 public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	 {
		 return par1Random.nextInt(2) == 0 ? new WorldGenThickTree2(false) : (par1Random.nextInt(7) == 0 ? new WorldGenThickTree3(false) : (par1Random.nextInt(3) == 0 ? new WorldGenFungi() : new WorldGenFungi()));
	 }

	 /**
	  * Gets a WorldGen appropriate for this biome.
	  */
	 @Override
	 public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
	 {
		 return (par1Random.nextInt(3) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 1) : (par1Random.nextInt(4) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 2) : (par1Random.nextInt(2) == 0 ? new WorldGenTallGrass(Blocks.foliage.get().blockID, 2) : new WorldGenTallGrass(Blocks.foliage.get().blockID, 1))));
	 }

	 /**
	  * Provides the basic grass color based on the biome temperature and rainfall
	  */
	 @Override
	 public int getBiomeGrassColor()
	 {
		 return 5359235;
	 }

	 /**
	  * Provides the basic foliage color based on the biome temperature and rainfall
	  */
	 @Override
	 public int getBiomeFoliageColor()
	 {
		 return 5359235;
	 }

	 /**
	  * takes temperature, returns color
	  */
	 @Override
	 public int getSkyColorByTemp(float par1)
	 {
		 if (BOPConfiguration.skyColors)
			 return 5888980;
		 else
		 {
			 par1 /= 3.0F;

			 if (par1 < -1.0F)
			 {
				 par1 = -1.0F;
			 }

			 if (par1 > 1.0F)
			 {
				 par1 = 1.0F;
			 }

			 return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
		 }
	 }
}
