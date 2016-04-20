package sub_mod.obj_item;

import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod (modid = ModItemObj.MODID, name = ModItemObj.MODNAME, version = ModItemObj.VERSION)

public class ModItemObj {

	public static final String MODID = "sub_mod_obj_item";
	public static final String MODNAME = "SM_OI";
	public static final String VERSION = "0.1a";

	@Instance(ModItemObj.MODID) public static ModItemObj instance;
	@SidedProxy(modId = ModItemObj.MODID, clientSide = "sub_mod.obj_item.ProxyClient", serverSide = "sub_mod.obj_item.ProxyCommon")
	public static ProxyCommon proxy;

	public static Item item_obj;
	public static int item_obj_id;

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		item_obj = new ItemObj(item_obj_id);
		GameRegistry.registerItem(item_obj, "item_obj");

		proxy.init();
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		item_obj_id = config.getItem("item_obj", 5600).getInt();

		config.save();

		proxy.preInit();

	}

}