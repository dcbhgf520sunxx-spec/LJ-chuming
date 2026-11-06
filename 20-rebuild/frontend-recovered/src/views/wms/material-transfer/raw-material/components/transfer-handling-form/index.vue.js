import { ref as f } from "vue";
import { computed as T } from "vue";
import { watch as v } from "vue";
import { nextTick as b } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as h } from "vue";
import { createBlock as w } from "vue";
import { withCtx as i } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as U } from "vue";
import { createElementVNode as V } from "vue";
import { resolveDynamicComponent as B } from "vue";
import { unref as y } from "vue";
import { isRef as $ } from "vue";
import { ElMessage as j } from "element-plus";
import { ElPopconfirm as M } from "element-plus";
import { ElForm as D } from "element-plus";
import { a as Q, g as W, o as z, s as G, b as J, c as Y } from "../../../../../../modules/transfer-handling-96ed23ad.js";
import { _ as K, xC as X, u as Z, bC as ee, x$ as p, bl as t, V as re, x_ as ae, b as te } from "../../../../../../shared/runtime.js";
import se from "./components/common-form-item.vue.js";
import oe from "./module/steel-plate.vue.js";
import ne from "./module/section-steel.vue.js";
import ie from "./module/steel-coil.vue.js";
import C from "./module/aux-mat.vue.js";
import le from "./module/gas.vue.js";
import ue from "./module/other.vue.js";
import "./components/common-material-info.vue.js";
const me = { class: "material-info" }, ce = { class: "form-info" }, de = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(I, { emit: x }) {
  const { realTimeValidate: R } = X(), _ = x, n = I, m = f(false), { visible: c, handleClose: g } = Z({ emit: _, props: n, field: "visible", showHook: l }), A = { transferType: [{ required: true, message: "请选择调拨类型", trigger: "change" }], projectId: [{ required: true, message: "请选择调拨项目", trigger: "change" }], workshopId: [{ required: true, message: "请选择调拨车间", trigger: "change" }], warehouseId: [{ required: true, message: "请选择调拨仓库", trigger: "change" }], quantity: [{ required: true, validator: (e, r, a) => {
    if (te(r)) return a(new Error("请填写数量"));
    if (r <= 0) return a(new Error("数量必须大于0"));
    if (r > d.value.corOperableQuantity) return a(new Error("数量不可超过可操作数量"));
    a();
  }, trigger: "blur" }], remark: [{ max: 200, message: "不能超过200个字符", trigger: "blur" }], realTime: [{ validator: R, message: "请选择实际调拨时间", trigger: "change" }] }, o = f(), s = f({}), d = T(() => n.material || {});
  ee(o, s, ["quantity"]), v(d, (e) => {
    L(e);
  }, { immediate: true, deep: true }), v(() => s.value.transferType, () => {
    s.value.transferType !== p.PROJECT_WARE.V && l("projectId"), s.value.transferType === p.RETURN_PARTY_A.V && (l("workshopId"), l("warehouseId"));
  });
  function L(e) {
    const r = { materialId: e.id, outboundUnit: e.outboundUnit, outboundUnitPrecision: e.outboundUnitPrecision, transferType: p.PROJECT_WARE.V, workshopId: e.workshop ? e.workshop.id : void 0, warehouseId: e.warehouse ? e.warehouse.id : void 0, quantity: void 0, remark: void 0, realTime: e.realTime || (/* @__PURE__ */ new Date()).getTime() };
    s.value = r;
  }
  function S() {
    b(() => {
      o.value && o.value.resetFields();
    });
  }
  function l(e) {
    b(() => {
    }), o.value && o.value.clearValidate(e);
  }
  async function k() {
    try {
      if (m.value = true, !await o.value.validate()) return false;
      const r = H(n.basicClass), a = re(s.value);
      await ae(a, { unit: a.outboundUnit, precision: a.outboundUnitPrecision, fields: ["quantity"], toSmallest: true, toNum: true }), await r(a), j.success("已提交调拨申请"), _("success"), g(), S();
    } catch (e) {
      console.log("调拨办理", e);
    } finally {
      m.value = false;
    }
  }
  const q = T(() => {
    switch (n.basicClass) {
      case t.STEEL_PLATE.V:
        return oe;
      case t.SECTION_STEEL.V:
        return ne;
      case t.STEEL_COIL.V:
        return ie;
      case t.MATERIAL.V:
        return C;
      case t.OTHER.V:
        return ue;
      case t.GAS.V:
        return le;
      default:
        return C;
    }
  });
  function H(e) {
    switch (e) {
      case t.STEEL_PLATE.V:
        return Y;
      case t.SECTION_STEEL.V:
        return J;
      case t.STEEL_COIL.V:
        return G;
      case t.OTHER.V:
        return z;
      case t.GAS.V:
        return W;
      default:
        return Q;
    }
  }
  return (e, r) => {
    const a = E("common-button"), O = M, P = D, F = E("common-dialog");
    return h(), w(F, { title: "调拨办理", modelValue: y(c), "onUpdate:modelValue": r[0] || (r[0] = (N) => $(c) ? c.value = N : null), width: "900px", "before-close": y(g), "show-close": true, "custom-class": "wms-transfer-handling", top: "10vh" }, { titleRight: i(() => [u(O, { title: "确认所选择的调拨日期正确么?", "confirm-button-text": "确认提交", onConfirm: k }, { reference: i(() => [u(a, { loading: m.value, size: "default", type: "primary" }, { default: i(() => r[1] || (r[1] = [U(" 提 交 ")])), _: 1, __: [1] }, 8, ["loading"])]), _: 1 })]), default: i(() => [u(P, { ref_key: "formRef", ref: o, class: "form", model: s.value, rules: A, size: "default", "label-position": "left", "label-width": "120px" }, { default: i(() => [V("div", me, [(h(), w(B(q.value), { material: n.material, basicClass: n.basicClass }, null, 8, ["material", "basicClass"]))]), V("div", ce, [u(se, { material: d.value, form: s.value }, null, 8, ["material", "form"])])]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ce = K(de, [["__scopeId", "data-v-d4807077"]]);
export {
  Ce as default
};
