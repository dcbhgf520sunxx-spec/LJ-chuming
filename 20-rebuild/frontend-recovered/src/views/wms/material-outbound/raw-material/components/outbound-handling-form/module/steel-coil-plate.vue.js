import { ref as m } from "vue";
import { provide as Io } from "vue";
import { reactive as ho } from "vue";
import { watch as go } from "vue";
import { nextTick as wo } from "vue";
import { resolveComponent as uo } from "vue";
import { openBlock as eo } from "vue";
import { createBlock as yo } from "vue";
import { withCtx as p } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as c } from "vue";
import { createTextVNode as h } from "vue";
import { unref as i } from "vue";
import { createElementBlock as Co } from "vue";
import { Fragment as So } from "vue";
import { withDirectives as to } from "vue";
import { vShow as ao } from "vue";
import { createCommentVNode as _o } from "vue";
import { isRef as ko } from "vue";
import { ElMessage as Vo } from "element-plus";
import { u as xo, jY as No, o as qo, i as lo, qS as no, jl as Bo, c as Ao, x_ as ro, y5 as Ro } from "../../../../../../../shared/runtime.js";
import To from "./steel-coil-plate-form.vue.js";
import Ho from "./steel-coil-preview.vue.js";
import "../components/descriptions-material-info.vue.js";
import "../../../../../../../modules/index-330e9f5e.js";
import "./preview-form.vue.js";
const Eo = { class: "step-btn" }, Mo = { __name: "steel-coil-plate", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(so, { emit: io }) {
  const g = io, e = so, v = m(), r = m(), o = m({ plateObj: { list: [] }, outbound: { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } } }), { visible: n, handleClose: w } = xo({ emit: g, props: e, field: "visible", showHook: fo }), { outboundCfg: mo } = No();
  Io("outboundCfg", mo);
  const bo = m(), y = ho([{ title: "条板处理" }, { title: "预览" }]), l = m(0), O = m(false);
  function po() {
    switch (l.value) {
      case 0:
        return v.value.validateSubmit();
      case 1:
        return r.value.validateSubmit();
    }
  }
  go(() => n.value, (F) => {
    F && (l.value = 0, o.value = { plateObj: { list: [] }, outbound: { plateForm: { totalObj: {} }, surplusForm: { totalObj: {} } } });
  });
  const { maxHeight: C } = qo({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, n);
  function co() {
    l.value === 1 && r.value && r.value.assignForm(), l.value--;
  }
  async function vo() {
    var t, u, s, d, b, S, _, k, V, x, N, q, B, A, R, T, H, E, Q, J, L, z, U, D, P, M, Y, W, G, K, X, Z;
    if (await po()) {
      if (l.value === 0) {
        const jo = JSON.parse(JSON.stringify(o.value.plateObj.list)) || [], $ = JSON.parse(JSON.stringify(o.value.plateObj)), f = [], oo = [];
        jo.forEach((a) => {
          a.boolSurplus ? f.push(a) : oo.push(a);
        }), o.value.outbound.plateForm.totalObj = {}, o.value.outbound.surplusForm.totalObj = {};
        const j = [];
        o.value.outbound.plateForm.totalObj.segmentQuantity = 0, o.value.outbound.plateForm.totalObj.quantity = 0, o.value.outbound.plateForm.totalObj.width = 0, o.value.outbound.plateForm.totalObj.mete = 0, oo.forEach((a) => {
          o.value.outbound.plateForm.totalObj.specification = e.material.specification, o.value.outbound.plateForm.totalObj.segmentQuantity++, o.value.outbound.plateForm.totalObj.thickness = a.thickness, o.value.outbound.plateForm.totalObj.quantity += a.quantity, o.value.outbound.plateForm.totalObj.width += a.width * a.quantity, o.value.outbound.plateForm.totalObj.mete += a.mete, j.includes(a.width) || j.push(a.width);
        }), o.value.outbound.plateForm.boolSurplus = false, o.value.outbound.plateForm.boolOutbound = lo(o.value.outbound.plateForm.boolOutbound) ? o.value.outbound.plateForm.boolOutbound : true, o.value.outbound.plateForm.totalObj.segmentQuantity = o.value.outbound.plateForm.totalObj.segmentQuantity / j.length, o.value.outbound.plateForm.totalObj.width = o.value.outbound.plateForm.totalObj.width / o.value.outbound.plateForm.totalObj.segmentQuantity, o.value.outbound.plateForm.basicClass = e.basicClass, o.value.outbound.plateForm.factoryId = (u = (t = e.material) == null ? void 0 : t.factory) == null ? void 0 : u.id, o.value.outbound.plateForm.projectId = o.value.outbound.plateForm.projectId || ((d = (s = e.material) == null ? void 0 : s.project) == null ? void 0 : d.id) || ((b = o.value.outbound.plateForm) != null && b.boolOutbound ? void 0 : "common"), o.value.outbound.plateForm.monomerId = o.value.outbound.plateForm.projectId && o.value.outbound.plateForm.projectId !== "common" ? o.value.outbound.plateForm.monomerId || (o.value.outbound.plateForm.projectId === ((_ = (S = e.material) == null ? void 0 : S.project) == null ? void 0 : _.id) ? ((V = (k = e.material) == null ? void 0 : k.monomer) == null ? void 0 : V.id) || ((x = e.material) == null ? void 0 : x.monomerId) : void 0) : void 0, o.value.outbound.plateForm.areaId = o.value.outbound.plateForm.monomerId ? o.value.outbound.plateForm.areaId || (o.value.outbound.plateForm.monomerId === (((q = (N = e.material) == null ? void 0 : N.monomer) == null ? void 0 : q.id) || ((B = e.material) == null ? void 0 : B.monomerId)) ? ((R = (A = e.material) == null ? void 0 : A.area) == null ? void 0 : R.id) || ((T = e.material) == null ? void 0 : T.areaId) : void 0) : void 0, o.value.outbound.plateForm.recipientId = o.value.outbound.plateForm.recipientId || $.recipientId, o.value.outbound.plateForm.outboundAddress = o.value.outbound.plateForm.outboundAddress || (o.value.outbound.plateForm.boolOutbound ? no.FACTORY.V : void 0), o.value.outbound.surplusForm.totalObj.segmentQuantity = 0, o.value.outbound.surplusForm.totalObj.quantity = 0, o.value.outbound.surplusForm.totalObj.width = 0, o.value.outbound.surplusForm.totalObj.mete = 0, f.forEach((a) => {
          o.value.outbound.surplusForm.totalObj.specification = e.material.specification, o.value.outbound.surplusForm.totalObj.thickness = a.thickness, o.value.outbound.surplusForm.totalObj.quantity += a.quantity, o.value.outbound.surplusForm.totalObj.width += a.width, o.value.outbound.surplusForm.totalObj.mete += a.mete;
        }), o.value.outbound.surplusForm.totalObj.width = f.length ? o.value.outbound.surplusForm.totalObj.width / f.length : 0, o.value.outbound.surplusForm.totalObj.segmentQuantity = o.value.outbound.surplusForm.totalObj.quantity, o.value.outbound.surplusForm.boolSurplus = true, o.value.outbound.surplusForm.boolOutbound = lo(o.value.outbound.surplusForm.boolOutbound) ? o.value.outbound.surplusForm.boolOutbound : false, o.value.outbound.surplusForm.basicClass = e.basicClass, o.value.outbound.surplusForm.basicClass = e.basicClass, o.value.outbound.surplusForm.factoryId = (E = (H = e.material) == null ? void 0 : H.factory) == null ? void 0 : E.id, o.value.outbound.surplusForm.projectId = o.value.outbound.surplusForm.projectId || ((J = (Q = e.material) == null ? void 0 : Q.project) == null ? void 0 : J.id) || ((L = o.value.outbound.surplusForm) != null && L.boolOutbound ? void 0 : "common"), o.value.outbound.surplusForm.monomerId = o.value.outbound.surplusForm.projectId && o.value.outbound.surplusForm.projectId !== "common" ? o.value.outbound.surplusForm.monomerId || (o.value.outbound.surplusForm.projectId === ((U = (z = e.material) == null ? void 0 : z.project) == null ? void 0 : U.id) ? ((P = (D = e.material) == null ? void 0 : D.monomer) == null ? void 0 : P.id) || ((M = e.material) == null ? void 0 : M.monomerId) : void 0) : void 0, o.value.outbound.surplusForm.areaId = o.value.outbound.surplusForm.monomerId ? o.value.outbound.surplusForm.areaId || (o.value.outbound.surplusForm.monomerId === (((W = (Y = e.material) == null ? void 0 : Y.monomer) == null ? void 0 : W.id) || ((G = e.material) == null ? void 0 : G.monomerId)) ? ((X = (K = e.material) == null ? void 0 : K.area) == null ? void 0 : X.id) || ((Z = e.material) == null ? void 0 : Z.areaId) : void 0) : void 0, o.value.outbound.surplusForm.recipientId = o.value.outbound.surplusForm.recipientId || $.recipientId, o.value.outbound.surplusForm.outboundAddress = o.value.outbound.surplusForm.outboundAddress || (o.value.outbound.surplusForm.boolOutbound ? no.FACTORY.V : void 0);
      }
      console.log(o.value.outbound), l.value++;
    }
  }
  function Fo() {
    r.value && r.value.clearValidate(), v.value && v.value.clearValidate();
  }
  function fo() {
    wo(() => {
      Fo();
    });
  }
  async function Oo() {
    if (!await r.value.validateSubmit()) return;
    const t = JSON.parse(JSON.stringify(o.value.plateObj));
    t.list.forEach((u) => {
      var s, d, b;
      u.boolSurplus ? (u.boolOutbound = (d = o.value.outbound.surplusForm) == null ? void 0 : d.boolOutbound, u.projectId = o.value.outbound.surplusForm.projectId === "common" ? null : o.value.outbound.surplusForm.projectId, u.monomerId = o.value.outbound.surplusForm.monomerId, u.areaId = o.value.outbound.surplusForm.areaId, u.workshopId = o.value.outbound.surplusForm.workshopId, u.recipientId = u.boolOutbound ? o.value.outbound.surplusForm.recipientId : void 0, u.outboundTime = u.boolOutbound ? o.value.outbound.surplusForm.outboundTime : void 0, u.warehouseId = (b = o.value.outbound.surplusForm) == null ? void 0 : b.warehouseId, u.outboundAddress = u.boolOutbound ? o.value.outbound.surplusForm.outboundAddress : void 0) : (u.boolOutbound = o.value.outbound.plateForm.boolOutbound, u.projectId = o.value.outbound.plateForm.projectId === "common" ? null : o.value.outbound.plateForm.projectId, u.monomerId = o.value.outbound.plateForm.monomerId, u.areaId = o.value.outbound.plateForm.areaId, u.workshopId = o.value.outbound.plateForm.workshopId, u.recipientId = u.boolOutbound ? o.value.outbound.plateForm.recipientId : void 0, u.outboundTime = u.boolOutbound ? o.value.outbound.plateForm.outboundTime : void 0, u.warehouseId = (s = o.value.outbound.plateForm) == null ? void 0 : s.warehouseId, u.outboundAddress = u.boolOutbound ? o.value.outbound.plateForm.outboundAddress : void 0);
    }), t.battenList = t.list, t.battenList = await Bo(t.battenList, { toSmallest: true, toNum: true }, { weight: ["mete"] }), t.quantity = Ao(t.quantity, "mm", "m"), await ro(t, { unit: e.material.measureUnit, precision: e.material.measurePrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await ro(t, { unit: e.material.accountingUnit, precision: e.material.accountingPrecision, fields: ["totalWeight"], toSmallest: true, toNum: true });
    try {
      O.value = true, await Ro(t), Vo.success("条板转换已提交"), g("success"), w();
    } catch (u) {
      console.log("条板转换办理", u);
    } finally {
      O.value = false;
    }
  }
  return (F, t) => {
    const u = uo("common-button"), s = uo("common-drawer");
    return eo(), yo(s, { ref_key: "dialogRef", ref: bo, title: "条板转换办理", modelValue: i(n), "onUpdate:modelValue": t[0] || (t[0] = (d) => ko(n) ? n.value = d : null), size: l.value === 0 ? "80%" : "960", "before-close": i(w), "append-to-body": "", "close-on-click-modal": false, "wrapper-closable": false, "custom-class": "wms-outbound-handling" }, { titleRight: p(() => [I("span", Eo, [c(u, { size: "default", plain: "", disabled: l.value === 0, onClick: co }, { default: p(() => t[1] || (t[1] = [h("上一步")])), _: 1, __: [1] }, 8, ["disabled"]), c(u, { size: "default", plain: "", disabled: l.value === y.length - 1, onClick: vo }, { default: p(() => t[2] || (t[2] = [h("下一步")])), _: 1, __: [2] }, 8, ["disabled"]), c(u, { loading: O.value, size: "default", type: "warning", disabled: l.value !== y.length - 1, onClick: Oo }, { default: p(() => t[3] || (t[3] = [h(" 确认提交 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])])]), content: p(() => [i(n) ? (eo(), Co(So, { key: 0 }, [to(I("div", null, [c(To, { ref_key: "plateRef", ref: v, visibleVal: i(n), "basic-class": e.basicClass, material: e.material, "max-height": i(C), "form-data": o.value.plateObj }, null, 8, ["visibleVal", "basic-class", "material", "max-height", "form-data"])], 512), [[ao, l.value === 0]]), to(I("div", null, [c(Ho, { ref_key: "previewRef", ref: r, visibleVal: i(n), "basic-class": e.basicClass, material: e.material, "max-height": i(C), "form-data": o.value.outbound }, null, 8, ["visibleVal", "basic-class", "material", "max-height", "form-data"])], 512), [[ao, l.value === 1]])], 64)) : _o("", true)]), _: 1 }, 8, ["modelValue", "size", "before-close"]);
  };
} };
export {
  Mo as default
};
