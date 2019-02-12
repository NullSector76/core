package com.nullsector76.core;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.Name("nullsector-core-test")
@IFMLLoadingPlugin.SortingIndex(1001)
@IFMLLoadingPlugin.MCVersion("1.12.2")
public class FMLCorePlugin implements IFMLLoadingPlugin
{
	public static boolean isObf;

	@Override
	public String[] getASMTransformerClass() 
	{
		return new String[]{"com.nullsector76.core.Transformer"};
	}

	@Override
	public String getModContainerClass() 
	{
		return null;
	}

	@Override
	public String getSetupClass() 
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) 
	{
		isObf = (Boolean) data.get("runtimeDeobfuscationEnabled");
	}

	@Override
	public String getAccessTransformerClass() 
	{
		return null;
	}
	
}