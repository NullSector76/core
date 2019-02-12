package com.nullsector76.core;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import net.minecraft.launchwrapper.IClassTransformer;

public class Transformer implements IClassTransformer{
	
	public static final List<String> clazzes = new ArrayList<String>();
	static
	{
		String[] list = new String[]
		{
		    	"net.minecraft.client.Minecraft"
		};
		for(String s : list)
			clazzes.add(s);
	}
	
     
    
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass)
    {
        int index = clazzes.indexOf(transformedName);
        return index != -1 ? patch(name,basicClass) : basicClass;
    }

	private byte[] patch(String name, byte[] basicClass) 
	{
		System.out.println("Transforming:" + name);
		ClassNode classNode = new ClassNode();
        ClassReader classReader = new ClassReader(basicClass);
        classReader.accept(classNode, 0);
        
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(classWriter);
		return classWriter.toByteArray();
	}

}
