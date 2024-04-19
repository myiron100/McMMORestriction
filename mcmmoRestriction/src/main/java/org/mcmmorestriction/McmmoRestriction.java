package org.mcmmorestriction;

import com.gmail.nossr50.api.ExperienceAPI;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 import java.io.File;
 import java.io.IOException;


 import java.util.stream.Collectors;

 import org.bukkit.ChatColor;
 import org.bukkit.Material;
 import org.bukkit.Particle;
 import org.bukkit.Sound;
 import org.bukkit.configuration.file.FileConfiguration;
 import org.bukkit.configuration.file.YamlConfiguration;
 import org.bukkit.entity.Item;
 import org.bukkit.entity.Player;
 import org.bukkit.event.EventHandler;

 import org.bukkit.event.block.BlockBreakEvent;
 import org.bukkit.event.inventory.PrepareSmithingEvent;
 import org.bukkit.event.player.PlayerInteractEvent;
 import org.bukkit.event.player.PlayerPickupItemEvent;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.SmithingInventory;
 import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Set;


public final class McmmoRestriction extends JavaPlugin implements Listener {




           private int ironLevel;
           private int copperLevel;
           private int emeraldLevel;
           private int quartzLevel;
           private int coalLevel;
           private int diamondLevel;
           private int netheriteLevel;
           private int goldLevel;
           private int lapisLevel;
           private int redstoneLevel;
           private Set<Material> copperItems;
           private Set<Material> copperBlocks;
           private Set<Material> redstoneItems;
           private Set<Material> redstoneBlocks;
           private Set<Material> emeraldItems;
           private Set<Material> emeraldBlocks;
           private Set<Material> quartzItems;
           private Set<Material> quartzBlocks;
           private Set<Material> lapisItems;
           private Set<Material> lapisBlocks;
           private Set<Material> coalItems;
           private Set<Material> coalBlocks;
           private Set<Material> goldItems;
           private Set<Material> goldBlocks;
           private Set<Material> ironItems;
           private Set<Material> ironBlocks;
           private Set<Material> diamondItems;
           private Set<Material> diamondBlocks;
           private Set<Material> netheriteItems;
           private Set<Material> netheriteBlocks;

        
           public void reload() {
                 loadLanguageFile();
                 reloadConfig();
                 loadSettingsFile();
            
            
            
            
                 List<String> copperItemsList = this.settingsConfig.getStringList("copperItems");
                 List<String> copperBlocksList = this.settingsConfig.getStringList("copperBlocks");
                 this.copperItems = copperItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.copperBlocks = copperBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> redstoneItemsList = this.settingsConfig.getStringList("redstoneItems");
                 List<String> redstoneBlocksList = this.settingsConfig.getStringList("redstoneBlocks");
                 this.redstoneItems = redstoneItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.redstoneBlocks = redstoneBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> emeraldItemsList = this.settingsConfig.getStringList("emeraldItems");
                 List<String> emeraldBlocksList = this.settingsConfig.getStringList("emeraldBlocks");
                 this.emeraldItems = emeraldItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.emeraldBlocks = emeraldBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> quartzItemsList = this.settingsConfig.getStringList("quartzItems");
                 List<String> quartzBlocksList = this.settingsConfig.getStringList("quartzBlocks");
                 this.quartzItems = quartzItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.quartzBlocks = quartzBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> lapisItemsList = this.settingsConfig.getStringList("lapisItems");
                 List<String> lapisBlocksList = this.settingsConfig.getStringList("lapisBlocks");
                 this.lapisItems = lapisItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.lapisBlocks = lapisBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> coalItemsList = this.settingsConfig.getStringList("coalItems");
                 List<String> coalBlocksList = this.settingsConfig.getStringList("coalBlocks");
                 this.coalItems = coalItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.coalBlocks = coalBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> goldItemsList = this.settingsConfig.getStringList("goldItems");
                 List<String> goldBlocksList = this.settingsConfig.getStringList("goldBlocks");
                 this.goldItems = goldItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.goldBlocks = goldBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> ironItemsList = this.settingsConfig.getStringList("ironItems");
                 List<String> ironBlocksList = this.settingsConfig.getStringList("ironBlocks");
                 this.ironItems = ironItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.ironBlocks = ironBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> diamondItemsList = this.settingsConfig.getStringList("diamondItems");
                 List<String> diamondBlocksList = this.settingsConfig.getStringList("diamondBlocks");
                 this.diamondItems = diamondItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.diamondBlocks = diamondBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> netheriteItemsList = this.settingsConfig.getStringList("netheriteItems");
                 List<String> netheriteBlocksList = this.settingsConfig.getStringList("netheriteBlocks");
                 this.netheriteItems = netheriteItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.netheriteBlocks = netheriteBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
            
            
            
            
                 this.goldLevel = getConfig().getInt("gold-level", 15);
                 this.copperLevel = getConfig().getInt("copper-level", 40);
                 this.emeraldLevel = getConfig().getInt("emerald-level", 15);
                 this.quartzLevel = getConfig().getInt("quartz-level", 10);
                 this.coalLevel = getConfig().getInt("coal-level", 5);
                 this.redstoneLevel = getConfig().getInt("redstone-level", 25);
                 this.lapisLevel = getConfig().getInt("lapis-level", 30);
                 this.ironLevel = getConfig().getInt("iron-level", 20);
                 this.diamondLevel = getConfig().getInt("diamond-level", 60);
                 this.netheriteLevel = getConfig().getInt("netherite-level", 120);
                 this.onPlayerInteractItems = getConfig().getBoolean("events.onPlayerInteractItems", true);
                 this.onPlayerInteractNetheriteItems = getConfig().getBoolean("events.onPlayerInteractNetheriteItems", true);
                 this.onBlockBreakNetherite = getConfig().getBoolean("events.onBlockBreakNetherite", true);
                 this.onBlockBreak = getConfig().getBoolean("events.onBlockBreak", true);
                 this.onPlayerPickupItem = getConfig().getBoolean("events.onPlayerPickupItem", true);
                 this.onPlayerPickupItemNetherite = getConfig().getBoolean("events.onPlayerPickupItemNetherite", true);
                 this.onSmithingTable = getConfig().getBoolean("events.onSmithingTable", true);
            
                 this.onPlayerInteractIronItems = getConfig().getBoolean("events.onPlayerInteractIronItems", true);
                 this.onPlayerPickupIronItem = getConfig().getBoolean("events.onPlayerPickupIronItem", true);
                 this.onBlockBreakIron = getConfig().getBoolean("events.onBlockBreakIron", true);
            
            
                 this.onPlayerInteractGoldItems = getConfig().getBoolean("events.onPlayerInteractGoldItems", true);
                 this.onPlayerPickupGoldItem = getConfig().getBoolean("events.onPlayerPickupGoldItem", true);
                 this.onBlockBreakGold = getConfig().getBoolean("events.onBlockBreakGold", true);
            
            
                 this.onPlayerInteractCoalItems = getConfig().getBoolean("events.onPlayerInteractCoalItems", true);
                 this.onPlayerPickupCoalItem = getConfig().getBoolean("events.onPlayerPickupCoalItem", true);
                 this.onBlockBreakCoal = getConfig().getBoolean("events.onBlockBreakCoal", true);
            
            
                 this.onPlayerInteractLapisItems = getConfig().getBoolean("events.onPlayerInteractLapisItems", true);
                 this.onPlayerPickupLapisItem = getConfig().getBoolean("events.onPlayerPickupLapisItem", true);
                 this.onBlockBreakLapis = getConfig().getBoolean("events.onBlockBreakLapis", true);
            
            
                 this.onPlayerInteractQuartzItems = getConfig().getBoolean("events.onPlayerInteractQuartzItems", true);
                 this.onPlayerPickupQuartzItem = getConfig().getBoolean("events.onPlayerPickupQuartzItem", true);
                 this.onBlockBreakQuartz = getConfig().getBoolean("events.onBlockBreakQuartz", true);
            
            
                 this.onPlayerInteractEmeraldItems = getConfig().getBoolean("events.onPlayerInteractEmeraldItems", true);
                 this.onPlayerPickupEmeraldItem = getConfig().getBoolean("events.onPlayerPickupEmeraldItem", true);
                 this.onBlockBreakEmerald = getConfig().getBoolean("events.onBlockBreakEmerald", true);
            
            
                 this.onPlayerInteractRedstoneItems = getConfig().getBoolean("events.onPlayerInteractRedstoneItems", true);
                 this.onPlayerPickupRedstoneItem = getConfig().getBoolean("events.onPlayerPickupRedstoneItem", true);
                 this.onBlockBreakRedstone = getConfig().getBoolean("events.onBlockBreakRedstone", true);
            
            
            
                 this.onPlayerInteractCopperItems = getConfig().getBoolean("events.onPlayerInteractCopperItems", true);
                 this.onPlayerPickupCopperItem = getConfig().getBoolean("events.onPlayerPickupCopperItem", true);
                 this.onBlockBreakCopper = getConfig().getBoolean("events.onBlockBreakCopper", true);
            
                 getLogger().info("Configuration reloaded.");
               }
        
           private void loadLanguageFile() {
                 if (this.languageFile == null) {
                       this.languageFile = new File(getDataFolder(), "language.yml");
                     }
                 if (!this.languageFile.exists()) {
                       this.languageFile.getParentFile().mkdirs();
                       saveResource("language.yml", false);
                     }
                 this.languageConfig = (FileConfiguration)new YamlConfiguration();
                 try {
                       this.languageConfig.load(this.languageFile);
                     } catch (IOException | org.bukkit.configuration.InvalidConfigurationException e) {
                       e.printStackTrace();
                     }
               }
        
        
        
           private FileConfiguration languageConfig = null;
           private File languageFile = null;
        
        
           private FileConfiguration settingsConfig;
        
        
           private File settingsFile;
        
        
           private boolean onPlayerInteractNetheriteItems;
        
        
           private boolean onBlockBreakNetherite;
        
        
           private boolean onPlayerPickupItemNetherite;
        
        
           private boolean onBlockBreak;
        
        
           private boolean onPlayerInteractItems;
        
           private boolean onPlayerPickupItem;
        
           private boolean onSmithingTable;
        
           private boolean onPlayerInteractIronItems;
        
           private boolean onPlayerPickupIronItem;
        
           private boolean onBlockBreakIron;
        
           private boolean onPlayerInteractGoldItems;
        
           private boolean onPlayerPickupGoldItem;
        
           private boolean onBlockBreakGold;
        
           private boolean onPlayerInteractCoalItems;
        
           private boolean onPlayerPickupCoalItem;
        
           private boolean onBlockBreakCoal;
        
           private boolean onPlayerInteractLapisItems;
        
           private boolean onPlayerPickupLapisItem;
        
           private boolean onBlockBreakLapis;
        
           private boolean onPlayerInteractQuartzItems;
        
           private boolean onPlayerPickupQuartzItem;
        
           private boolean onBlockBreakQuartz;
        
           private boolean onPlayerInteractEmeraldItems;
        
           private boolean onPlayerPickupEmeraldItem;
        
           private boolean onBlockBreakEmerald;
        
           private boolean onPlayerInteractRedstoneItems;
        
           private boolean onPlayerPickupRedstoneItem;
        
           private boolean onBlockBreakRedstone;
        
           private boolean onPlayerInteractCopperItems;
        
           private boolean onPlayerPickupCopperItem;
        
           private boolean onBlockBreakCopper;
        
        
           public void onEnable() {

            
            
                 saveDefaultConfig();
            
                 loadLanguageFile();
            
            
                 this.settingsFile = new File(getDataFolder(), "settings.yml");
                 if (!this.settingsFile.exists()) {
                       this.settingsFile.getParentFile().mkdirs();
                       saveResource("settings.yml", false);
                     }
            
                 this.settingsConfig = YamlConfiguration.loadConfiguration(this.settingsFile);
            
                 List<String> copperItemsList = this.settingsConfig.getStringList("copperItems");
                 List<String> copperBlocksList = this.settingsConfig.getStringList("copperBlocks");
                 this.copperItems = copperItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.copperBlocks = copperBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> redstoneItemsList = this.settingsConfig.getStringList("redstoneItems");
                 List<String> redstoneBlocksList = this.settingsConfig.getStringList("redstoneBlocks");
                 this.redstoneItems = redstoneItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.redstoneBlocks = redstoneBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> emeraldItemsList = this.settingsConfig.getStringList("emeraldItems");
                 List<String> emeraldBlocksList = this.settingsConfig.getStringList("emeraldBlocks");
                 this.emeraldItems = emeraldItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.emeraldBlocks = emeraldBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> quartzItemsList = this.settingsConfig.getStringList("quartzItems");
                 List<String> quartzBlocksList = this.settingsConfig.getStringList("quartzBlocks");
                 this.quartzItems = quartzItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.quartzBlocks = quartzBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> lapisItemsList = this.settingsConfig.getStringList("lapisItems");
                 List<String> lapisBlocksList = this.settingsConfig.getStringList("lapisBlocks");
                 this.lapisItems = lapisItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.lapisBlocks = lapisBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> coalItemsList = this.settingsConfig.getStringList("coalItems");
                 List<String> coalBlocksList = this.settingsConfig.getStringList("coalBlocks");
                 this.coalItems = coalItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.coalBlocks = coalBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> goldItemsList = this.settingsConfig.getStringList("goldItems");
                 List<String> goldBlocksList = this.settingsConfig.getStringList("goldBlocks");
                 this.goldItems = goldItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.goldBlocks = goldBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> ironItemsList = this.settingsConfig.getStringList("ironItems");
                 List<String> ironBlocksList = this.settingsConfig.getStringList("ironBlocks");
                 this.ironItems = ironItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.ironBlocks = ironBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> diamondItemsList = this.settingsConfig.getStringList("diamondItems");
                 List<String> diamondBlocksList = this.settingsConfig.getStringList("diamondBlocks");
                 this.diamondItems = diamondItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.diamondBlocks = diamondBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
                 List<String> netheriteItemsList = this.settingsConfig.getStringList("netheriteItems");
                 List<String> netheriteBlocksList = this.settingsConfig.getStringList("netheriteBlocks");
                 this.netheriteItems = netheriteItemsList.stream().map(Material::valueOf).collect(Collectors.toSet());
                 this.netheriteBlocks = netheriteBlocksList.stream().map(Material::valueOf).collect(Collectors.toSet());
            
            
                 this.ironLevel = getConfig().getInt("iron-level", 20);
                 this.copperLevel = getConfig().getInt("copper-level", 40);
                 this.emeraldLevel = getConfig().getInt("emerald-level", 15);
                 this.quartzLevel = getConfig().getInt("quartz-level", 10);
                 this.lapisLevel = getConfig().getInt("lapis-level", 30);
                 this.goldLevel = getConfig().getInt("gold-level", 15);
                 this.coalLevel = getConfig().getInt("coal-level", 5);
                 this.redstoneLevel = getConfig().getInt("redstone-level", 25);
                 this.diamondLevel = getConfig().getInt("diamond-level", 60);
                 this.netheriteLevel = getConfig().getInt("netherite-level", 120);

            
                 this.onPlayerInteractItems = getConfig().getBoolean("events.onPlayerInteractItems", true);
                 this.onPlayerInteractNetheriteItems = getConfig().getBoolean("events.onPlayerInteractNetheriteItems", true);
                 this.onBlockBreakNetherite = getConfig().getBoolean("events.onBlockBreakNetherite", true);
                 this.onBlockBreak = getConfig().getBoolean("events.onBlockBreak", true);
                 this.onPlayerPickupItem = getConfig().getBoolean("events.onPlayerPickupItem", true);
                 this.onPlayerPickupItemNetherite = getConfig().getBoolean("events.onPlayerPickupItemNetherite", true);
                 this.onSmithingTable = getConfig().getBoolean("events.onSmithingTable", true);
            
                 this.onPlayerInteractIronItems = getConfig().getBoolean("events.onPlayerInteractIronItems", true);
                 this.onPlayerPickupIronItem = getConfig().getBoolean("events.onPlayerPickupIronItem", true);
                 this.onBlockBreakIron = getConfig().getBoolean("events.onBlockBreakIron", true);
            
            
                 this.onPlayerInteractGoldItems = getConfig().getBoolean("events.onPlayerInteractGoldItems", true);
                 this.onPlayerPickupGoldItem = getConfig().getBoolean("events.onPlayerPickupGoldItem", true);
                 this.onBlockBreakGold = getConfig().getBoolean("events.onBlockBreakGold", true);
            
            
                 this.onPlayerInteractCoalItems = getConfig().getBoolean("events.onPlayerInteractCoalItems", true);
                 this.onPlayerPickupCoalItem = getConfig().getBoolean("events.onPlayerPickupCoalItem", true);
                 this.onBlockBreakCoal = getConfig().getBoolean("events.onBlockBreakCoal", true);
            
            
                 this.onPlayerInteractLapisItems = getConfig().getBoolean("events.onPlayerInteractCoalItems", true);
                 this.onPlayerPickupLapisItem = getConfig().getBoolean("events.onPlayerPickupCoalItem", true);
                 this.onBlockBreakLapis = getConfig().getBoolean("events.onBlockBreakCoal", true);
            
            
                 this.onPlayerInteractQuartzItems = getConfig().getBoolean("events.onPlayerInteractQuartzItems", true);
                 this.onPlayerPickupQuartzItem = getConfig().getBoolean("events.onPlayerPickupQuartzItem", true);
                 this.onBlockBreakQuartz = getConfig().getBoolean("events.onBlockBreakQuartz", true);
            
            
            
                 this.onPlayerInteractEmeraldItems = getConfig().getBoolean("events.onPlayerInteractEmeraldItems", true);
                 this.onPlayerPickupEmeraldItem = getConfig().getBoolean("events.onPlayerPickupEmeraldItem", true);
                 this.onBlockBreakEmerald = getConfig().getBoolean("events.onBlockBreakEmerald", true);
            
            
            
                 this.onPlayerInteractRedstoneItems = getConfig().getBoolean("events.onPlayerInteractRedstoneItems", true);
                 this.onPlayerPickupRedstoneItem = getConfig().getBoolean("events.onPlayerPickupRedstoneItem", true);
                 this.onBlockBreakRedstone = getConfig().getBoolean("events.onBlockBreakRedstone", true);
            
            
            
                 this.onPlayerInteractCopperItems = getConfig().getBoolean("events.onPlayerInteractCopperItems", true);
                 this.onPlayerPickupCopperItem = getConfig().getBoolean("events.onPlayerPickupCopperItem", true);
                 this.onBlockBreakCopper = getConfig().getBoolean("events.onBlockBreakCopper", true);
            
            

            
                 getLogger().info("Aurelium Skills Restriction made by ironPhil24k");
                 getLogger().info("The Plugin Aurelium Restriction started successfully!");
            
                 getServer().getPluginManager().registerEvents(this, (Plugin)this);
               }
           private void loadSettingsFile() {
                 if (this.settingsFile == null) {
                       this.settingsFile = new File(getDataFolder(), "settings.yml");
                     }
                 if (!this.settingsFile.exists()) {
                       this.settingsFile.getParentFile().mkdirs();
                       saveResource("settings.yml", false);
                     }
                 this.settingsConfig = new YamlConfiguration();
                 try {
                       this.settingsConfig.load(this.settingsFile);
                     } catch (IOException|org.bukkit.configuration.InvalidConfigurationException e) {
                       e.printStackTrace();
                     }
               }
        
        
        
        
        
           public void onDisable() {
                 getLogger().info("The plugin seems to shut down correctly...");

            
                 try {
                       this.settingsConfig.save(this.settingsFile);
                     } catch (IOException e) {
                       e.printStackTrace();
                     }
               }

           @EventHandler
           public void onPlayerInteractItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.diamondItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.diamondLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.diamondLevel)));
                                 }
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        
        
        
        
           @EventHandler
           public void onBlockBreak(BlockBreakEvent event) {
                 if (!this.onBlockBreak)
                       return;  if (this.diamondBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.diamondLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.diamondLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.diamondItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.diamondLevel) {
                       event.setCancelled(true);
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.diamondLevel)));
                           }
                
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        

           @EventHandler
           public void onPlayerInteractNetheriteItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractNetheriteItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.netheriteItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.netheriteLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.netheriteLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        
           @EventHandler
           public void onBlockBreakNetherite(BlockBreakEvent event) {
                 if (!this.onBlockBreakNetherite)
                       return;  if (this.netheriteBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.netheriteLevel) {
                             event.setCancelled(true);
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.netheriteLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupItemNetherite(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupItemNetherite)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.netheriteItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.netheriteLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                               event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.netheriteLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onSmithingTable(PrepareSmithingEvent event) {
                 if (!this.onSmithingTable)
                       return;  if (!(event.getView().getPlayer() instanceof Player))
                       return;  Player player = (Player)event.getView().getPlayer();
                 SmithingInventory inventory = event.getInventory();
                 if (inventory.getResult() == null)
                       return;  if ((this.diamondItems.contains(inventory.getResult().getType()) && getMiningLevel(player) < this.diamondLevel) || (this.netheriteItems
       .contains(inventory.getResult().getType()) && getMiningLevel(player) < this.netheriteLevel)) {
                       event.setResult(new ItemStack(Material.AIR));
                     }
               }
        
        
        
           @EventHandler
           public void onBlockBreakiron(BlockBreakEvent event) {
                 if (!this.onBlockBreakIron)
                       return;  if (this.ironBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.ironLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.ironLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupIronItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupIronItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.ironItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.ironLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.ironLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractironItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractIronItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.ironItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.ironLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.ironLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        

        
           @EventHandler
           public void onBlockBreakGold(BlockBreakEvent event) {
                 if (!this.onBlockBreakGold)
                       return;  if (this.goldBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.goldLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.goldLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupGoldItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupGoldItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.goldItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.goldLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.goldLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractGoldItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractGoldItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.goldItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.goldLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.goldLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }

        
        
           @EventHandler
           public void onBlockBreakCoal(BlockBreakEvent event) {
                 if (!this.onBlockBreakCoal)
                       return;  if (this.coalBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.coalLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.coalLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupCoalItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupCoalItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.coalItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.coalLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                               event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.coalLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractCoalItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractCoalItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.coalItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.coalLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.coalLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }

           @EventHandler
           public void onBlockBreakLapis(BlockBreakEvent event) {
                 if (!this.onBlockBreakLapis)
                       return;  if (this.lapisBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.lapisLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.lapisLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupLapisItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupLapisItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.lapisItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.lapisLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                               event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.lapisLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractLapisItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractLapisItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.lapisItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.lapisLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.lapisLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }

        
        
           @EventHandler
           public void onBlockBreakQuartz(BlockBreakEvent event) {
                 if (!this.onBlockBreakQuartz)
                       return;  if (this.quartzBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.lapisLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.quartzLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupQuartzItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupQuartzItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.quartzItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.quartzLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.quartzLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractQuartzItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractQuartzItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.quartzItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.quartzLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.quartzLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }

        
        
        
           @EventHandler
           public void onBlockBreakEmerald(BlockBreakEvent event) {
                 if (!this.onBlockBreakEmerald)
                       return;  if (this.emeraldBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.emeraldLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.emeraldLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupEmeraldItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupEmeraldItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.emeraldItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.emeraldLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.emeraldLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractEmeraldItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractEmeraldItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.emeraldItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.emeraldLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.emeraldLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        

        
           @EventHandler
           public void onBlockBreakRedstone(BlockBreakEvent event) {
                 if (!this.onBlockBreakRedstone)
                       return;  if (this.redstoneBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.redstoneLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.redstoneLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupRedstoneItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupRedstoneItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.redstoneItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.redstoneLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.redstoneLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractRedstoneItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractRedstoneItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.redstoneItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.redstoneLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.redstoneLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        
        

           @EventHandler
           public void onBlockBreakCopper(BlockBreakEvent event) {
                 if (!this.onBlockBreakCopper)
                       return;  if (this.copperBlocks.contains(event.getBlock().getType()))
                     {
                       if (getMiningLevel(event.getPlayer()) < this.copperLevel) {
                             event.setCancelled(true);
                    
                    
                             String message = this.languageConfig.getString("messages.block_mine");
                             if (message != null) {
                                   event.getPlayer().sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.copperLevel)));
                                 }
                    
                    
                             event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                           }
                     }
               }
        
           @EventHandler
           public void onPlayerPickupCopperItem(PlayerPickupItemEvent event) {
                 if (!this.onPlayerPickupCopperItem)
                       return;  Material itemType = event.getItem().getItemStack().getType();
                 if (this.copperItems.contains(itemType) && getMiningLevel(event.getPlayer()) < this.copperLevel) {
                       event.setCancelled(true);
                
                
                       String message = this.languageConfig.getString("messages.pickup_item");
                       if (message != null) {
                             event.getPlayer().sendActionBar(ChatColor.RED + message.replace("{level}", String.valueOf(this.copperLevel)));
                           }
                
                
                       Item item = event.getItem();
                       item.getWorld().spawnParticle(Particle.SMOKE_NORMAL, item.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                     }
               }
        
        
           @EventHandler
           public void onPlayerInteractCopperItems(PlayerInteractEvent event) {
                 if (!this.onPlayerInteractCopperItems)
                       return;  Player player = event.getPlayer();
                 ItemStack heldItem = player.getInventory().getItemInMainHand();
            
                 if (this.copperItems.contains(heldItem.getType()))
                     {
                       if (getMiningLevel(player) < this.copperLevel) {
                             ItemStack itemCopy = heldItem.clone();
                             player.getInventory().setItemInMainHand(null);
                             player.getWorld().dropItem(player.getLocation(), itemCopy);
                    
                             String message = this.languageConfig.getString("messages.level_required");
                             if (message != null) {
                                   player.sendMessage(ChatColor.RED + message.replace("{level}", String.valueOf(this.copperLevel)));
                                 }
                    
                    
                             player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1.0F, 1.0F);
                    
                    
                             player.getWorld().spawnParticle(Particle.SMOKE_NORMAL, player.getLocation(), 10, 0.1D, 0.1D, 0.1D, 0.02D);
                           }
                     }
               }
        


        private int getMiningLevel(Player player) {
                return ExperienceAPI.getLevel(player, "MINING");
        }
}
