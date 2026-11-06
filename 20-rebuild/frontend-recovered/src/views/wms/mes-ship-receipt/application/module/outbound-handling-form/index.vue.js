import { _ as L, cJ as a, u as B, jY as M, o as S } from "../../../../../../shared/runtime.js";
import k from "./module/steel-plate.vue.js";
import I from "./module/section-steel.vue.js";
import j from "./module/steel-coil.vue.js";
import f from "./module/aux-mat.vue.js";
import A from "./module/gas.vue.js";
import N from "./module/other.vue.js";
import { computed as p } from "vue";
import { ref as b } from "vue";
import { provide as _ } from "vue";
import { watch as W } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as v } from "vue";
import { createBlock as h } from "vue";
import { withCtx as l } from "vue";
import { createVNode as D } from "vue";
import { createTextVNode as P } from "vue";
import { resolveDynamicComponent as q } from "vue";
import { unref as i } from "vue";
import { isRef as z } from "vue";
import { ElMessage as G } from "element-plus";
import "./components/common-form-item.vue.js";
import "./components/produce-form.vue.js";
import "./components/common-material-info.vue.js";
const J = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, currentRow: { type: Object, default: () => ({}) }, material: { type: Object } }, emits: ["success", "update:visible", "update:modelValue"], setup(u, { emit: x }) {
  const m = x, n = u, y = p(() => {
    switch (n.basicClass) {
      case a.STEEL_PLATE.V:
        return k;
      case a.SECTION_STEEL.V:
        return I;
      case a.STEEL_COIL.V:
        return j;
      case a.MATERIAL.V:
        return f;
      case a.OTHER.V:
        return N;
      case a.GAS.V:
        return A;
      default:
        return f;
    }
  }), o = b(), c = b(false), { visible: s, handleClose: d } = B({ emit: m, props: n }), { outboundCfg: w, selfOutboundTypeOptions: C } = M();
  _("outboundCfg", w), _("selfOutboundTypeOptions", C);
  const V = p(() => {
    var e;
    return (e = o.value) == null ? void 0 : e.enlargeWth;
  }), { maxHeight: E } = S({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, V);
  function r() {
    o.value && o.value.resetForm();
  }
  async function R() {
    var e;
    if (((e = o.value) == null ? void 0 : e.form.outboundQuantity) <= 0) {
      G.error("出库数量必须大于0");
      return;
    }
    try {
      await o.value.submit(), m("success", o.value.submitData), d(), r();
    } catch (t) {
      console.log("出库办理", t);
    } finally {
      c.value = false;
    }
  }
  function T() {
    r(), d();
  }
  return W(() => s.value, (e) => {
    e && r();
  }), (e, t) => {
    const O = g("common-button"), H = g("common-dialog");
    return v(), h(H, { modelValue: i(s), "onUpdate:modelValue": t[0] || (t[0] = (F) => z(s) ? s.value = F : null), "before-close": T, "close-on-click-modal": false, "show-close": true, top: "3vh", width: "800px", "custom-class": "wms-outbound-handling", title: "出库办理" }, { titleRight: l(() => [D(O, { loading: c.value, size: "default", type: "success", onClick: R }, { default: l(() => t[1] || (t[1] = [P("保存")])), _: 1, __: [1] }, 8, ["loading"])]), default: l(() => [(v(), h(q(y.value), { ref_key: "outboundFormRef", ref: o, "basic-class": n.basicClass, material: n.material, "max-height": i(E), currentRow: u.currentRow, visible: i(s) }, null, 8, ["basic-class", "material", "max-height", "currentRow", "visible"]))]), _: 1 }, 8, ["modelValue"]);
  };
} }, se = L(J, [["__scopeId", "data-v-e349b583"]]);
export {
  se as default
};
