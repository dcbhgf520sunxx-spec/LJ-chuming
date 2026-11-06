import { useStore as ho } from "vuex";
import { ref as m } from "vue";
import { provide as go } from "vue";
import { reactive as wo } from "vue";
import { watch as yo } from "vue";
import { nextTick as Co } from "vue";
import { resolveComponent as eo } from "vue";
import { openBlock as uo } from "vue";
import { createBlock as So } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as h } from "vue";
import { unref as i } from "vue";
import { createElementBlock as _o } from "vue";
import { Fragment as ko } from "vue";
import { withDirectives as to } from "vue";
import { vShow as ao } from "vue";
import { createCommentVNode as Vo } from "vue";
import { isRef as xo } from "vue";
import { ElMessage as No } from "element-plus";
import { u as qo, jY as Bo, zJ as Ao, o as Ro, i as lo, qS as no, jl as To, c as Ho, x_ as ro, y5 as Eo } from "../../../../../../../../../shared/runtime.js";
import Jo from "./steel-coil-plate-form.vue.js";
import Qo from "./steel-coil-preview.vue.js";
import "../components/descriptions-material-info.vue.js";
import "../../../../../../../../../modules/index-330e9f5e.js";
import "./preview-form.vue.js";
const zo = { class: "step-btn" }, Go = { __name: "steel-coil-plate", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(so, { emit: io }) {
  const mo = ho(), g = io, u = so, v = m(), r = m(), o = m({ plateObj: { list: [] }, outbound: { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } } }), { visible: n, handleClose: w } = qo({ emit: g, props: u, field: "visible", showHook: Oo }), { outboundCfg: bo } = Bo();
  Ao(), go("outboundCfg", bo);
  const po = m(), y = wo([{ title: "条板处理" }, { title: "预览" }]), l = m(0), O = m(false);
  function co() {
    switch (l.value) {
      case 0:
        return v.value.validateSubmit();
      case 1:
        return r.value.validateSubmit();
    }
  }
  yo(() => n.value, (F) => {
    F && (l.value = 0, o.value = { plateObj: { list: [] }, outbound: { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } } });
  });
  const { maxHeight: C } = Ro({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, n);
  function vo() {
    l.value === 1 && r.value && r.value.assignForm(), l.value--;
  }
  async function Fo() {
    var t, e, s, d, b, S, _, k, V, x, N, q, B, A, R, T, H, E, J, Q, z, D, L, U, P, M, Y, W, G, K, X, Z;
    if (await co()) {
      if (l.value === 0) {
        const Io = JSON.parse(JSON.stringify(o.value.plateObj.list)) || [], $ = JSON.parse(JSON.stringify(o.value.plateObj)), f = [], oo = [];
        Io.forEach((a) => {
          a.boolSurplus ? f.push(a) : oo.push(a);
        }), o.value.outbound.plateForm.totalObj = {}, o.value.outbound.surplusForm.totalObj = {};
        const j = [];
        o.value.outbound.plateForm.totalObj.segmentQuantity = 0, o.value.outbound.plateForm.totalObj.quantity = 0, o.value.outbound.plateForm.totalObj.width = 0, o.value.outbound.plateForm.totalObj.mete = 0, oo.forEach((a) => {
          o.value.outbound.plateForm.totalObj.specification = u.material.specification, o.value.outbound.plateForm.totalObj.segmentQuantity++, o.value.outbound.plateForm.totalObj.thickness = a.thickness, o.value.outbound.plateForm.totalObj.quantity += a.quantity, o.value.outbound.plateForm.totalObj.width += a.width * a.quantity, o.value.outbound.plateForm.totalObj.mete += a.mete, j.includes(a.width) || j.push(a.width);
        }), o.value.outbound.plateForm.boolSurplus = false, o.value.outbound.plateForm.boolOutbound = lo(o.value.outbound.plateForm.boolOutbound) ? o.value.outbound.plateForm.boolOutbound : true, o.value.outbound.plateForm.totalObj.segmentQuantity = o.value.outbound.plateForm.totalObj.segmentQuantity / j.length, o.value.outbound.plateForm.totalObj.width = o.value.outbound.plateForm.totalObj.width / o.value.outbound.plateForm.totalObj.segmentQuantity, o.value.outbound.plateForm.basicClass = u.basicClass, o.value.outbound.plateForm.factoryId = (e = (t = u.material) == null ? void 0 : t.factory) == null ? void 0 : e.id, o.value.outbound.plateForm.projectId = o.value.outbound.plateForm.projectId || ((d = (s = u.material) == null ? void 0 : s.project) == null ? void 0 : d.id) || ((b = o.value.outbound.plateForm) != null && b.boolOutbound ? void 0 : "common"), o.value.outbound.plateForm.monomerId = o.value.outbound.plateForm.projectId && o.value.outbound.plateForm.projectId !== "common" ? o.value.outbound.plateForm.monomerId || (o.value.outbound.plateForm.projectId === ((_ = (S = u.material) == null ? void 0 : S.project) == null ? void 0 : _.id) ? ((V = (k = u.material) == null ? void 0 : k.monomer) == null ? void 0 : V.id) || ((x = u.material) == null ? void 0 : x.monomerId) : void 0) : void 0, o.value.outbound.plateForm.areaId = o.value.outbound.plateForm.monomerId ? o.value.outbound.plateForm.areaId || (o.value.outbound.plateForm.monomerId === (((q = (N = u.material) == null ? void 0 : N.monomer) == null ? void 0 : q.id) || ((B = u.material) == null ? void 0 : B.monomerId)) ? ((R = (A = u.material) == null ? void 0 : A.area) == null ? void 0 : R.id) || ((T = u.material) == null ? void 0 : T.areaId) : void 0) : void 0, o.value.outbound.plateForm.recipientId = o.value.outbound.plateForm.recipientId || $.recipientId, o.value.outbound.plateForm.outboundAddress = o.value.outbound.plateForm.outboundAddress || (o.value.outbound.plateForm.boolOutbound ? no.FACTORY.V : void 0), o.value.outbound.surplusForm.totalObj.segmentQuantity = 0, o.value.outbound.surplusForm.totalObj.quantity = 0, o.value.outbound.surplusForm.totalObj.width = 0, o.value.outbound.surplusForm.totalObj.mete = 0, f.forEach((a) => {
          o.value.outbound.surplusForm.totalObj.specification = u.material.specification, o.value.outbound.surplusForm.totalObj.thickness = a.thickness, o.value.outbound.surplusForm.totalObj.quantity += a.quantity, o.value.outbound.surplusForm.totalObj.width += a.width, o.value.outbound.surplusForm.totalObj.mete += a.mete;
        }), o.value.outbound.surplusForm.totalObj.width = f.length ? o.value.outbound.surplusForm.totalObj.width / f.length : 0, o.value.outbound.surplusForm.totalObj.segmentQuantity = o.value.outbound.surplusForm.totalObj.quantity, o.value.outbound.surplusForm.boolSurplus = true, o.value.outbound.surplusForm.boolOutbound = lo(o.value.outbound.surplusForm.boolOutbound) ? o.value.outbound.surplusForm.boolOutbound : false, o.value.outbound.surplusForm.basicClass = u.basicClass, o.value.outbound.surplusForm.basicClass = u.basicClass, o.value.outbound.surplusForm.factoryId = (E = (H = u.material) == null ? void 0 : H.factory) == null ? void 0 : E.id, o.value.outbound.surplusForm.projectId = o.value.outbound.surplusForm.projectId || ((Q = (J = u.material) == null ? void 0 : J.project) == null ? void 0 : Q.id) || ((z = o.value.outbound.surplusForm) != null && z.boolOutbound ? void 0 : "common"), o.value.outbound.surplusForm.monomerId = o.value.outbound.surplusForm.projectId && o.value.outbound.surplusForm.projectId !== "common" ? o.value.outbound.surplusForm.monomerId || (o.value.outbound.surplusForm.projectId === ((L = (D = u.material) == null ? void 0 : D.project) == null ? void 0 : L.id) ? ((P = (U = u.material) == null ? void 0 : U.monomer) == null ? void 0 : P.id) || ((M = u.material) == null ? void 0 : M.monomerId) : void 0) : void 0, o.value.outbound.surplusForm.areaId = o.value.outbound.surplusForm.monomerId ? o.value.outbound.surplusForm.areaId || (o.value.outbound.surplusForm.monomerId === (((W = (Y = u.material) == null ? void 0 : Y.monomer) == null ? void 0 : W.id) || ((G = u.material) == null ? void 0 : G.monomerId)) ? ((X = (K = u.material) == null ? void 0 : K.area) == null ? void 0 : X.id) || ((Z = u.material) == null ? void 0 : Z.areaId) : void 0) : void 0, o.value.outbound.surplusForm.recipientId = o.value.outbound.surplusForm.recipientId || $.recipientId, o.value.outbound.surplusForm.outboundAddress = o.value.outbound.surplusForm.outboundAddress || (o.value.outbound.surplusForm.boolOutbound ? no.FACTORY.V : void 0);
      }
      console.log(o.value.outbound), l.value++;
    }
  }
  function fo() {
    r.value && r.value.clearValidate(), v.value && v.value.clearValidate();
  }
  function Oo() {
    Co(() => {
      fo();
    });
  }
  async function jo() {
    if (!await r.value.validateSubmit()) return;
    const t = JSON.parse(JSON.stringify(o.value.plateObj));
    t.list.forEach((e) => {
      var s, d, b;
      e.boolSurplus ? (e.boolOutbound = (d = o.value.outbound.surplusForm) == null ? void 0 : d.boolOutbound, e.projectId = o.value.outbound.surplusForm.projectId === "common" ? null : o.value.outbound.surplusForm.projectId, e.monomerId = o.value.outbound.surplusForm.monomerId, e.areaId = o.value.outbound.surplusForm.areaId, e.workshopId = o.value.outbound.surplusForm.workshopId, e.recipientId = e.boolOutbound ? o.value.outbound.surplusForm.recipientId : void 0, e.outboundTime = e.boolOutbound ? o.value.outbound.surplusForm.outboundTime : void 0, e.warehouseId = (b = o.value.outbound.surplusForm) == null ? void 0 : b.warehouseId, e.outboundAddress = e.boolOutbound ? o.value.outbound.surplusForm.outboundAddress : void 0) : (e.boolOutbound = o.value.outbound.plateForm.boolOutbound, e.projectId = o.value.outbound.plateForm.projectId === "common" ? null : o.value.outbound.plateForm.projectId, e.monomerId = o.value.outbound.plateForm.monomerId, e.areaId = o.value.outbound.plateForm.areaId, e.workshopId = o.value.outbound.plateForm.workshopId, e.recipientId = e.boolOutbound ? o.value.outbound.plateForm.recipientId : void 0, e.outboundTime = e.boolOutbound ? o.value.outbound.plateForm.outboundTime : void 0, e.warehouseId = (s = o.value.outbound.plateForm) == null ? void 0 : s.warehouseId, e.outboundAddress = e.boolOutbound ? o.value.outbound.plateForm.outboundAddress : void 0);
    }), t.battenList = t.list, t.battenList = await To(t.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] }), t.quantity = Ho(t.quantity, "mm", "m"), await ro(t, { unit: u.material.measureUnit, precision: u.material.measurePrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await ro(t, { unit: u.material.accountingUnit, precision: u.material.accountingPrecision, fields: ["totalWeight"], toSmallest: true, toNum: true }), await mo.dispatch("wms/fetchSteelDensityCfg");
    try {
      O.value = true, await Eo(t), No.success("条板转换已提交"), g("success"), w();
    } catch (e) {
      console.log("条板转换办理", e);
    } finally {
      O.value = false;
    }
  }
  return (F, t) => {
    const e = eo("common-button"), s = eo("common-drawer");
    return uo(), So(s, { ref_key: "dialogRef", ref: po, modelValue: i(n), "onUpdate:modelValue": t[0] || (t[0] = (d) => xo(n) ? n.value = d : null), "before-close": i(w), "close-on-click-modal": false, size: l.value === 0 ? "80%" : "960", "wrapper-closable": false, "append-to-body": "", "custom-class": "wms-outbound-handling", title: "条板转换办理" }, { titleRight: p(() => [I("span", zo, [c(e, { size: "default", plain: "", disabled: l.value === 0, onClick: vo }, { default: p(() => t[1] || (t[1] = [h("上一步")])), _: 1, __: [1] }, 8, ["disabled"]), c(e, { size: "default", plain: "", disabled: l.value === y.length - 1, onClick: Fo }, { default: p(() => t[2] || (t[2] = [h("下一步")])), _: 1, __: [2] }, 8, ["disabled"]), c(e, { loading: O.value, size: "default", type: "warning", disabled: l.value !== y.length - 1, onClick: jo }, { default: p(() => t[3] || (t[3] = [h(" 确认提交 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])])]), content: p(() => [i(n) ? (uo(), _o(ko, { key: 0 }, [to(I("div", null, [c(Jo, { ref_key: "plateRef", ref: v, "basic-class": u.basicClass, "form-data": o.value.plateObj, material: u.material, "max-height": i(C), visibleVal: i(n) }, null, 8, ["basic-class", "form-data", "material", "max-height", "visibleVal"])], 512), [[ao, l.value === 0]]), to(I("div", null, [c(Qo, { ref_key: "previewRef", ref: r, "basic-class": u.basicClass, "form-data": o.value.outbound, material: u.material, "max-height": i(C), visibleVal: i(n) }, null, 8, ["basic-class", "form-data", "material", "max-height", "visibleVal"])], 512), [[ao, l.value === 1]])], 64)) : Vo("", true)]), _: 1 }, 8, ["modelValue", "before-close", "size"]);
  };
} };
export {
  Go as default
};
