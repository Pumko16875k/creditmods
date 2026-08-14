package fr.fifoube.blocks.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import fr.fifoube.blocks.tileentity.TileEntityBlockBills;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelBills extends Model {
   TileEntityBlockBills te;
   ModelRenderer Bills01 = new ModelRenderer(this, 0, 0);
   ModelRenderer Bills02;
   ModelRenderer Bills03;
   ModelRenderer Bills04;
   ModelRenderer Bills05;
   ModelRenderer Bills06;
   ModelRenderer Bills07;
   ModelRenderer Bills08;
   ModelRenderer Bills09;
   ModelRenderer Bills10;
   ModelRenderer Bills11;
   ModelRenderer Bills12;
   ModelRenderer Bills13;
   ModelRenderer Bills14;
   ModelRenderer Bills15;
   ModelRenderer Bills16;
   ModelRenderer Bills17;
   ModelRenderer Bills18;
   ModelRenderer Bills19;
   ModelRenderer Bills20;
   ModelRenderer Bills21;
   ModelRenderer Bills22;
   ModelRenderer Bills23;
   ModelRenderer Bills24;
   ModelRenderer Bills25;
   ModelRenderer Bills26;
   ModelRenderer Bills27;
   ModelRenderer Bills28;
   ModelRenderer Bills29;
   ModelRenderer Bills30;
   ModelRenderer Bills31;
   ModelRenderer Bills32;
   ModelRenderer Bills33;
   ModelRenderer Bills34;
   ModelRenderer Bills35;
   ModelRenderer Bills36;
   ModelRenderer Bills37;
   ModelRenderer Bills38;
   ModelRenderer Bills39;
   ModelRenderer Bills40;
   ModelRenderer Bills41;
   ModelRenderer Bills42;
   ModelRenderer Bills43;
   ModelRenderer Bills44;
   ModelRenderer Bills45;
   ModelRenderer Bills46;
   ModelRenderer Bills47;
   ModelRenderer Bills48;
   ModelRenderer Bills49;
   ModelRenderer Bills50;
   ModelRenderer Bills51;
   ModelRenderer Bills52;
   ModelRenderer Bills53;
   ModelRenderer Bills54;
   ModelRenderer Bills55;
   ModelRenderer Bills56;
   ModelRenderer Bills57;
   ModelRenderer Bills58;
   ModelRenderer Bills59;
   ModelRenderer Bills60;
   ModelRenderer Bills61;
   ModelRenderer Bills62;
   ModelRenderer Bills63;
   ModelRenderer Bills64;
   ModelRenderer Platform;

   public ModelBills(Function<ResourceLocation, RenderType> f) {
      super(f);
      this.Bills01.func_78787_b(256, 128);
      this.Bills01.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills01.func_78793_a(0.0F, 21.0F, 0.0F);
      this.Bills02 = new ModelRenderer(this, 0, 0);
      this.Bills02.func_78787_b(256, 128);
      this.Bills02.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills02.func_78793_a(12.0F, 21.0F, 0.0F);
      this.Bills03 = new ModelRenderer(this, 0, 0);
      this.Bills03.func_78787_b(256, 128);
      this.Bills03.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills03.func_78793_a(24.0F, 21.0F, 0.0F);
      this.Bills04 = new ModelRenderer(this, 0, 0);
      this.Bills04.func_78787_b(256, 128);
      this.Bills04.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills04.func_78793_a(36.0F, 21.0F, 0.0F);
      this.Bills05 = new ModelRenderer(this, 0, 0);
      this.Bills05.func_78787_b(256, 128);
      this.Bills05.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills05.func_78793_a(0.0F, 21.0F, -24.0F);
      this.Bills06 = new ModelRenderer(this, 0, 0);
      this.Bills06.func_78787_b(256, 128);
      this.Bills06.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills06.func_78793_a(12.0F, 21.0F, -24.0F);
      this.Bills07 = new ModelRenderer(this, 0, 0);
      this.Bills07.func_78787_b(256, 128);
      this.Bills07.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills07.func_78793_a(24.0F, 21.0F, -24.0F);
      this.Bills08 = new ModelRenderer(this, 0, 0);
      this.Bills08.func_78787_b(256, 128);
      this.Bills08.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills08.func_78793_a(36.0F, 21.0F, -24.0F);
      this.Bills09 = new ModelRenderer(this, 0, 0);
      this.Bills09.func_78787_b(256, 128);
      this.Bills09.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills09.func_78793_a(0.0F, 18.0F, 0.0F);
      this.Bills10 = new ModelRenderer(this, 0, 0);
      this.Bills10.func_78787_b(256, 128);
      this.Bills10.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills10.func_78793_a(12.0F, 18.0F, 0.0F);
      this.Bills11 = new ModelRenderer(this, 0, 0);
      this.Bills11.func_78787_b(256, 128);
      this.Bills11.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills11.func_78793_a(24.0F, 18.0F, 0.0F);
      this.Bills12 = new ModelRenderer(this, 0, 0);
      this.Bills12.func_78787_b(256, 128);
      this.Bills12.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills12.func_78793_a(36.0F, 18.0F, 0.0F);
      this.Bills13 = new ModelRenderer(this, 0, 0);
      this.Bills13.func_78787_b(256, 128);
      this.Bills13.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills13.func_78793_a(0.0F, 18.0F, -24.0F);
      this.Bills14 = new ModelRenderer(this, 0, 0);
      this.Bills14.func_78787_b(256, 128);
      this.Bills14.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills14.func_78793_a(12.0F, 18.0F, -24.0F);
      this.Bills15 = new ModelRenderer(this, 0, 0);
      this.Bills15.func_78787_b(256, 128);
      this.Bills15.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills15.func_78793_a(24.0F, 18.0F, -24.0F);
      this.Bills16 = new ModelRenderer(this, 0, 0);
      this.Bills16.func_78787_b(256, 128);
      this.Bills16.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills16.func_78793_a(36.0F, 18.0F, -24.0F);
      this.Bills17 = new ModelRenderer(this, 0, 0);
      this.Bills17.func_78787_b(256, 128);
      this.Bills17.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills17.func_78793_a(0.0F, 15.0F, 0.0F);
      this.Bills18 = new ModelRenderer(this, 0, 0);
      this.Bills18.func_78787_b(256, 128);
      this.Bills18.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills18.func_78793_a(12.0F, 15.0F, 0.0F);
      this.Bills19 = new ModelRenderer(this, 0, 0);
      this.Bills19.func_78787_b(256, 128);
      this.Bills19.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills19.func_78793_a(24.0F, 15.0F, 0.0F);
      this.Bills20 = new ModelRenderer(this, 0, 0);
      this.Bills20.func_78787_b(256, 128);
      this.Bills20.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills20.func_78793_a(36.0F, 15.0F, 0.0F);
      this.Bills21 = new ModelRenderer(this, 0, 0);
      this.Bills21.func_78787_b(256, 128);
      this.Bills21.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills21.func_78793_a(0.0F, 15.0F, -24.0F);
      this.Bills22 = new ModelRenderer(this, 0, 0);
      this.Bills22.func_78787_b(256, 128);
      this.Bills22.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills22.func_78793_a(12.0F, 15.0F, -24.0F);
      this.Bills23 = new ModelRenderer(this, 0, 0);
      this.Bills23.func_78787_b(256, 128);
      this.Bills23.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills23.func_78793_a(24.0F, 15.0F, -24.0F);
      this.Bills24 = new ModelRenderer(this, 0, 0);
      this.Bills24.func_78787_b(256, 128);
      this.Bills24.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills24.func_78793_a(36.0F, 15.0F, -24.0F);
      this.Bills25 = new ModelRenderer(this, 0, 0);
      this.Bills25.func_78787_b(256, 128);
      this.Bills25.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills25.func_78793_a(0.0F, 12.0F, 0.0F);
      this.Bills26 = new ModelRenderer(this, 0, 0);
      this.Bills26.func_78787_b(256, 128);
      this.Bills26.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills26.func_78793_a(12.0F, 12.0F, 0.0F);
      this.Bills27 = new ModelRenderer(this, 0, 0);
      this.Bills27.func_78787_b(256, 128);
      this.Bills27.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills27.func_78793_a(24.0F, 12.0F, 0.0F);
      this.Bills28 = new ModelRenderer(this, 0, 0);
      this.Bills28.func_78787_b(256, 128);
      this.Bills28.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills28.func_78793_a(36.0F, 12.0F, 0.0F);
      this.Bills29 = new ModelRenderer(this, 0, 0);
      this.Bills29.func_78787_b(256, 128);
      this.Bills29.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills29.func_78793_a(0.0F, 12.0F, -24.0F);
      this.Bills30 = new ModelRenderer(this, 0, 0);
      this.Bills30.func_78787_b(256, 128);
      this.Bills30.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills30.func_78793_a(12.0F, 12.0F, -24.0F);
      this.Bills31 = new ModelRenderer(this, 0, 0);
      this.Bills31.func_78787_b(256, 128);
      this.Bills31.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills31.func_78793_a(24.0F, 12.0F, -24.0F);
      this.Bills32 = new ModelRenderer(this, 0, 0);
      this.Bills32.func_78787_b(256, 128);
      this.Bills32.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills32.func_78793_a(36.0F, 12.0F, -24.0F);
      this.Bills33 = new ModelRenderer(this, 0, 0);
      this.Bills33.func_78787_b(256, 128);
      this.Bills33.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills33.func_78793_a(0.0F, 9.0F, 0.0F);
      this.Bills34 = new ModelRenderer(this, 0, 0);
      this.Bills34.func_78787_b(256, 128);
      this.Bills34.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills34.func_78793_a(12.0F, 9.0F, 0.0F);
      this.Bills35 = new ModelRenderer(this, 0, 0);
      this.Bills35.func_78787_b(256, 128);
      this.Bills35.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills35.func_78793_a(24.0F, 9.0F, 0.0F);
      this.Bills36 = new ModelRenderer(this, 0, 0);
      this.Bills36.func_78787_b(256, 128);
      this.Bills36.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills36.func_78793_a(36.0F, 9.0F, 0.0F);
      this.Bills37 = new ModelRenderer(this, 0, 0);
      this.Bills37.func_78787_b(256, 128);
      this.Bills37.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills37.func_78793_a(0.0F, 9.0F, -24.0F);
      this.Bills38 = new ModelRenderer(this, 0, 0);
      this.Bills38.func_78787_b(256, 128);
      this.Bills38.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills38.func_78793_a(12.0F, 9.0F, -24.0F);
      this.Bills39 = new ModelRenderer(this, 0, 0);
      this.Bills39.func_78787_b(256, 128);
      this.Bills39.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills39.func_78793_a(24.0F, 9.0F, -24.0F);
      this.Bills40 = new ModelRenderer(this, 0, 0);
      this.Bills40.func_78787_b(256, 128);
      this.Bills40.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills40.func_78793_a(36.0F, 9.0F, -24.0F);
      this.Bills41 = new ModelRenderer(this, 0, 0);
      this.Bills41.func_78787_b(256, 128);
      this.Bills41.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills41.func_78793_a(0.0F, 6.0F, 0.0F);
      this.Bills42 = new ModelRenderer(this, 0, 0);
      this.Bills42.func_78787_b(256, 128);
      this.Bills42.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills42.func_78793_a(12.0F, 6.0F, 0.0F);
      this.Bills43 = new ModelRenderer(this, 0, 0);
      this.Bills43.func_78787_b(256, 128);
      this.Bills43.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills43.func_78793_a(24.0F, 6.0F, 0.0F);
      this.Bills44 = new ModelRenderer(this, 0, 0);
      this.Bills44.func_78787_b(256, 128);
      this.Bills44.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills44.func_78793_a(36.0F, 6.0F, 0.0F);
      this.Bills45 = new ModelRenderer(this, 0, 0);
      this.Bills45.func_78787_b(256, 128);
      this.Bills45.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills45.func_78793_a(0.0F, 6.0F, -24.0F);
      this.Bills46 = new ModelRenderer(this, 0, 0);
      this.Bills46.func_78787_b(256, 128);
      this.Bills46.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills46.func_78793_a(12.0F, 6.0F, -24.0F);
      this.Bills47 = new ModelRenderer(this, 0, 0);
      this.Bills47.func_78787_b(256, 128);
      this.Bills47.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills47.func_78793_a(24.0F, 6.0F, -24.0F);
      this.Bills48 = new ModelRenderer(this, 0, 0);
      this.Bills48.func_78787_b(256, 128);
      this.Bills48.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills48.func_78793_a(36.0F, 6.0F, -24.0F);
      this.Bills49 = new ModelRenderer(this, 0, 0);
      this.Bills49.func_78787_b(256, 128);
      this.Bills49.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills49.func_78793_a(0.0F, 3.0F, 0.0F);
      this.Bills50 = new ModelRenderer(this, 0, 0);
      this.Bills50.func_78787_b(256, 128);
      this.Bills50.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills50.func_78793_a(12.0F, 3.0F, 0.0F);
      this.Bills51 = new ModelRenderer(this, 0, 0);
      this.Bills51.func_78787_b(256, 128);
      this.Bills51.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills51.func_78793_a(24.0F, 3.0F, 0.0F);
      this.Bills52 = new ModelRenderer(this, 0, 0);
      this.Bills52.func_78787_b(256, 128);
      this.Bills52.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills52.func_78793_a(0.0F, 3.0F, -24.0F);
      this.Bills53 = new ModelRenderer(this, 0, 0);
      this.Bills53.func_78787_b(256, 128);
      this.Bills53.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills53.func_78793_a(24.0F, 3.0F, -24.0F);
      this.Bills54 = new ModelRenderer(this, 0, 0);
      this.Bills54.func_78787_b(256, 128);
      this.Bills54.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills54.func_78793_a(36.0F, 3.0F, -24.0F);
      this.Bills55 = new ModelRenderer(this, 0, 0);
      this.Bills55.func_78787_b(256, 128);
      this.Bills55.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills55.func_78793_a(0.0F, 0.0F, 0.0F);
      this.Bills56 = new ModelRenderer(this, 0, 0);
      this.Bills56.func_78787_b(256, 128);
      this.Bills56.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills56.func_78793_a(12.0F, 0.0F, 0.0F);
      this.Bills57 = new ModelRenderer(this, 0, 0);
      this.Bills57.func_78787_b(256, 128);
      this.Bills57.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills57.func_78793_a(24.0F, 0.0F, 0.0F);
      this.Bills58 = new ModelRenderer(this, 0, 0);
      this.Bills58.func_78787_b(256, 128);
      this.Bills58.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills58.func_78793_a(0.0F, 0.0F, -24.0F);
      this.Bills59 = new ModelRenderer(this, 0, 0);
      this.Bills59.func_78787_b(256, 128);
      this.Bills59.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills59.func_78793_a(24.0F, 0.0F, -24.0F);
      this.Bills60 = new ModelRenderer(this, 0, 0);
      this.Bills60.func_78787_b(256, 128);
      this.Bills60.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills60.func_78793_a(36.0F, 0.0F, -24.0F);
      this.Bills61 = new ModelRenderer(this, 0, 0);
      this.Bills61.func_78787_b(256, 128);
      this.Bills61.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills61.func_78793_a(0.0F, -3.0F, 0.0F);
      this.Bills62 = new ModelRenderer(this, 0, 0);
      this.Bills62.func_78787_b(256, 128);
      this.Bills62.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills62.func_78793_a(24.0F, -3.0F, 0.0F);
      this.Bills63 = new ModelRenderer(this, 0, 0);
      this.Bills63.func_78787_b(256, 128);
      this.Bills63.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills63.func_78793_a(0.0F, -6.0F, 0.0F);
      this.Bills64 = new ModelRenderer(this, 0, 0);
      this.Bills64.func_78787_b(256, 128);
      this.Bills64.func_228300_a_(-6.0F, -1.5F, -12.0F, 12.0F, 3.0F, 24.0F);
      this.Bills64.func_78793_a(0.0F, -9.0F, 0.0F);
      this.Platform = new ModelRenderer(this, 0, 77);
      this.Platform.func_78787_b(256, 128);
      this.Platform.func_228300_a_(-24.0F, -1.5F, -24.0F, 48.0F, 3.0F, 48.0F);
      this.Platform.func_78793_a(18.0F, 24.0F, -12.0F);
   }

   public void renderAll(TileEntityBlockBills te, MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      this.te = te;
      this.func_225598_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
   }

   public void func_225598_a_(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
      this.Platform.field_78795_f = 0.0F;
      this.Platform.field_78796_g = 0.0F;
      this.Platform.field_78808_h = 0.0F;
      this.Platform.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      if (this.te.getNumbBills() >= 1) {
         this.Bills01.field_78795_f = 0.0F;
         this.Bills01.field_78796_g = 0.0F;
         this.Bills01.field_78808_h = 0.0F;
         this.Bills01.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 2) {
         this.Bills02.field_78795_f = 0.0F;
         this.Bills02.field_78796_g = 0.0F;
         this.Bills02.field_78808_h = 0.0F;
         this.Bills02.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 3) {
         this.Bills03.field_78795_f = 0.0F;
         this.Bills03.field_78796_g = 0.0F;
         this.Bills03.field_78808_h = 0.0F;
         this.Bills03.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 4) {
         this.Bills04.field_78795_f = 0.0F;
         this.Bills04.field_78796_g = 0.0F;
         this.Bills04.field_78808_h = 0.0F;
         this.Bills04.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 5) {
         this.Bills05.field_78795_f = 0.0F;
         this.Bills05.field_78796_g = 0.0F;
         this.Bills05.field_78808_h = 0.0F;
         this.Bills05.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 6) {
         this.Bills06.field_78795_f = 0.0F;
         this.Bills06.field_78796_g = 0.0F;
         this.Bills06.field_78808_h = 0.0F;
         this.Bills06.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 7) {
         this.Bills07.field_78795_f = 0.0F;
         this.Bills07.field_78796_g = 0.0F;
         this.Bills07.field_78808_h = 0.0F;
         this.Bills07.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 8) {
         this.Bills08.field_78795_f = 0.0F;
         this.Bills08.field_78796_g = 0.0F;
         this.Bills08.field_78808_h = 0.0F;
         this.Bills08.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 9) {
         this.Bills09.field_78795_f = 0.0F;
         this.Bills09.field_78796_g = 0.0F;
         this.Bills09.field_78808_h = 0.0F;
         this.Bills09.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 10) {
         this.Bills10.field_78795_f = 0.0F;
         this.Bills10.field_78796_g = 0.0F;
         this.Bills10.field_78808_h = 0.0F;
         this.Bills10.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 11) {
         this.Bills11.field_78795_f = 0.0F;
         this.Bills11.field_78796_g = 0.0F;
         this.Bills11.field_78808_h = 0.0F;
         this.Bills11.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 12) {
         this.Bills12.field_78795_f = 0.0F;
         this.Bills12.field_78796_g = 0.0F;
         this.Bills12.field_78808_h = 0.0F;
         this.Bills12.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 13) {
         this.Bills13.field_78795_f = 0.0F;
         this.Bills13.field_78796_g = 0.0F;
         this.Bills13.field_78808_h = 0.0F;
         this.Bills13.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 14) {
         this.Bills14.field_78795_f = 0.0F;
         this.Bills14.field_78796_g = 0.0F;
         this.Bills14.field_78808_h = 0.0F;
         this.Bills14.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 15) {
         this.Bills15.field_78795_f = 0.0F;
         this.Bills15.field_78796_g = 0.0F;
         this.Bills15.field_78808_h = 0.0F;
         this.Bills15.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 16) {
         this.Bills16.field_78795_f = 0.0F;
         this.Bills16.field_78796_g = 0.0F;
         this.Bills16.field_78808_h = 0.0F;
         this.Bills16.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 17) {
         this.Bills17.field_78795_f = 0.0F;
         this.Bills17.field_78796_g = 0.0F;
         this.Bills17.field_78808_h = 0.0F;
         this.Bills17.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 18) {
         this.Bills18.field_78795_f = 0.0F;
         this.Bills18.field_78796_g = 0.0F;
         this.Bills18.field_78808_h = 0.0F;
         this.Bills18.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 19) {
         this.Bills19.field_78795_f = 0.0F;
         this.Bills19.field_78796_g = 0.0F;
         this.Bills19.field_78808_h = 0.0F;
         this.Bills19.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 20) {
         this.Bills20.field_78795_f = 0.0F;
         this.Bills20.field_78796_g = 0.0F;
         this.Bills20.field_78808_h = 0.0F;
         this.Bills20.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 21) {
         this.Bills21.field_78795_f = 0.0F;
         this.Bills21.field_78796_g = 0.0F;
         this.Bills21.field_78808_h = 0.0F;
         this.Bills21.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 22) {
         this.Bills22.field_78795_f = 0.0F;
         this.Bills22.field_78796_g = 0.0F;
         this.Bills22.field_78808_h = 0.0F;
         this.Bills22.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 23) {
         this.Bills23.field_78795_f = 0.0F;
         this.Bills23.field_78796_g = 0.0F;
         this.Bills23.field_78808_h = 0.0F;
         this.Bills23.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 24) {
         this.Bills24.field_78795_f = 0.0F;
         this.Bills24.field_78796_g = 0.0F;
         this.Bills24.field_78808_h = 0.0F;
         this.Bills24.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 25) {
         this.Bills25.field_78795_f = 0.0F;
         this.Bills25.field_78796_g = 0.0F;
         this.Bills25.field_78808_h = 0.0F;
         this.Bills25.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 26) {
         this.Bills26.field_78795_f = 0.0F;
         this.Bills26.field_78796_g = 0.0F;
         this.Bills26.field_78808_h = 0.0F;
         this.Bills26.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 27) {
         this.Bills27.field_78795_f = 0.0F;
         this.Bills27.field_78796_g = 0.0F;
         this.Bills27.field_78808_h = 0.0F;
         this.Bills27.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 28) {
         this.Bills28.field_78795_f = 0.0F;
         this.Bills28.field_78796_g = 0.0F;
         this.Bills28.field_78808_h = 0.0F;
         this.Bills28.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 29) {
         this.Bills29.field_78795_f = 0.0F;
         this.Bills29.field_78796_g = 0.0F;
         this.Bills29.field_78808_h = 0.0F;
         this.Bills29.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 30) {
         this.Bills30.field_78795_f = 0.0F;
         this.Bills30.field_78796_g = 0.0F;
         this.Bills30.field_78808_h = 0.0F;
         this.Bills30.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 31) {
         this.Bills31.field_78795_f = 0.0F;
         this.Bills31.field_78796_g = 0.0F;
         this.Bills31.field_78808_h = 0.0F;
         this.Bills31.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 32) {
         this.Bills32.field_78795_f = 0.0F;
         this.Bills32.field_78796_g = 0.0F;
         this.Bills32.field_78808_h = 0.0F;
         this.Bills32.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 33) {
         this.Bills33.field_78795_f = 0.0F;
         this.Bills33.field_78796_g = 0.0F;
         this.Bills33.field_78808_h = 0.0F;
         this.Bills33.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 34) {
         this.Bills34.field_78795_f = 0.0F;
         this.Bills34.field_78796_g = 0.0F;
         this.Bills34.field_78808_h = 0.0F;
         this.Bills34.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 35) {
         this.Bills35.field_78795_f = 0.0F;
         this.Bills35.field_78796_g = 0.0F;
         this.Bills35.field_78808_h = 0.0F;
         this.Bills35.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 36) {
         this.Bills36.field_78795_f = 0.0F;
         this.Bills36.field_78796_g = 0.0F;
         this.Bills36.field_78808_h = 0.0F;
         this.Bills36.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 37) {
         this.Bills37.field_78795_f = 0.0F;
         this.Bills37.field_78796_g = 0.0F;
         this.Bills37.field_78808_h = 0.0F;
         this.Bills37.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 38) {
         this.Bills38.field_78795_f = 0.0F;
         this.Bills38.field_78796_g = 0.0F;
         this.Bills38.field_78808_h = 0.0F;
         this.Bills38.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 39) {
         this.Bills39.field_78795_f = 0.0F;
         this.Bills39.field_78796_g = 0.0F;
         this.Bills39.field_78808_h = 0.0F;
         this.Bills39.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 40) {
         this.Bills40.field_78795_f = 0.0F;
         this.Bills40.field_78796_g = 0.0F;
         this.Bills40.field_78808_h = 0.0F;
         this.Bills40.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 41) {
         this.Bills41.field_78795_f = 0.0F;
         this.Bills41.field_78796_g = 0.0F;
         this.Bills41.field_78808_h = 0.0F;
         this.Bills41.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 42) {
         this.Bills42.field_78795_f = 0.0F;
         this.Bills42.field_78796_g = 0.0F;
         this.Bills42.field_78808_h = 0.0F;
         this.Bills42.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 43) {
         this.Bills43.field_78795_f = 0.0F;
         this.Bills43.field_78796_g = 0.0F;
         this.Bills43.field_78808_h = 0.0F;
         this.Bills43.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 44) {
         this.Bills44.field_78795_f = 0.0F;
         this.Bills44.field_78796_g = 0.0F;
         this.Bills44.field_78808_h = 0.0F;
         this.Bills44.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 45) {
         this.Bills45.field_78795_f = 0.0F;
         this.Bills45.field_78796_g = 0.0F;
         this.Bills45.field_78808_h = 0.0F;
         this.Bills45.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 46) {
         this.Bills46.field_78795_f = 0.0F;
         this.Bills46.field_78796_g = 0.0F;
         this.Bills46.field_78808_h = 0.0F;
         this.Bills46.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 47) {
         this.Bills47.field_78795_f = 0.0F;
         this.Bills47.field_78796_g = 0.0F;
         this.Bills47.field_78808_h = 0.0F;
         this.Bills47.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 48) {
         this.Bills48.field_78795_f = 0.0F;
         this.Bills48.field_78796_g = 0.0F;
         this.Bills48.field_78808_h = 0.0F;
         this.Bills48.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 49) {
         this.Bills49.field_78795_f = 0.0F;
         this.Bills49.field_78796_g = 0.0F;
         this.Bills49.field_78808_h = 0.0F;
         this.Bills49.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 50) {
         this.Bills50.field_78795_f = 0.0F;
         this.Bills50.field_78796_g = 0.0F;
         this.Bills50.field_78808_h = 0.0F;
         this.Bills50.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 51) {
         this.Bills51.field_78795_f = 0.0F;
         this.Bills51.field_78796_g = 0.0F;
         this.Bills51.field_78808_h = 0.0F;
         this.Bills51.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 52) {
         this.Bills52.field_78795_f = 0.0F;
         this.Bills52.field_78796_g = 0.0F;
         this.Bills52.field_78808_h = 0.0F;
         this.Bills52.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 53) {
         this.Bills53.field_78795_f = 0.0F;
         this.Bills53.field_78796_g = 0.0F;
         this.Bills53.field_78808_h = 0.0F;
         this.Bills53.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 54) {
         this.Bills54.field_78795_f = 0.0F;
         this.Bills54.field_78796_g = 0.0F;
         this.Bills54.field_78808_h = 0.0F;
         this.Bills54.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 55) {
         this.Bills55.field_78795_f = 0.0F;
         this.Bills55.field_78796_g = 0.0F;
         this.Bills55.field_78808_h = 0.0F;
         this.Bills55.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 56) {
         this.Bills56.field_78795_f = 0.0F;
         this.Bills56.field_78796_g = 0.0F;
         this.Bills56.field_78808_h = 0.0F;
         this.Bills56.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 57) {
         this.Bills57.field_78795_f = 0.0F;
         this.Bills57.field_78796_g = 0.0F;
         this.Bills57.field_78808_h = 0.0F;
         this.Bills57.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 58) {
         this.Bills58.field_78795_f = 0.0F;
         this.Bills58.field_78796_g = 0.0F;
         this.Bills58.field_78808_h = 0.0F;
         this.Bills58.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 59) {
         this.Bills59.field_78795_f = 0.0F;
         this.Bills59.field_78796_g = 0.0F;
         this.Bills59.field_78808_h = 0.0F;
         this.Bills59.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 60) {
         this.Bills60.field_78795_f = 0.0F;
         this.Bills60.field_78796_g = 0.0F;
         this.Bills60.field_78808_h = 0.0F;
         this.Bills60.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 61) {
         this.Bills61.field_78795_f = 0.0F;
         this.Bills61.field_78796_g = 0.0F;
         this.Bills61.field_78808_h = 0.0F;
         this.Bills61.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 62) {
         this.Bills62.field_78795_f = 0.0F;
         this.Bills62.field_78796_g = 0.0F;
         this.Bills62.field_78808_h = 0.0F;
         this.Bills62.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 63) {
         this.Bills63.field_78795_f = 0.0F;
         this.Bills63.field_78796_g = 0.0F;
         this.Bills63.field_78808_h = 0.0F;
         this.Bills63.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

      if (this.te.getNumbBills() >= 64) {
         this.Bills64.field_78795_f = 0.0F;
         this.Bills64.field_78796_g = 0.0F;
         this.Bills64.field_78808_h = 0.0F;
         this.Bills64.func_228309_a_(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
      }

   }
}
