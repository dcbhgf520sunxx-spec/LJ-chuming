import { bl as o, u as A, jY as B, o as M } from "../../../../../../../../shared/runtime.js";
import S from "./module/steel-plate.vue.js";
import F from "./module/section-steel.vue.js";
import I from "./module/steel-coil.vue.js";
import p from "./module/aux-mat.vue.js";
import N from "./module/gas.vue.js";
import j from "./module/other.vue.js";
import { computed as d } from "vue";
import { ref as f } from "vue";
import { provide as b } from "vue";
import { nextTick as W } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as h } from "vue";
import { createBlock as v } from "vue";
import { withCtx as n } from "vue";
import { createVNode as P } from "vue";
import { createTextVNode as q } from "vue";
import { resolveDynamicComponent as z } from "vue";
import { unref as u } from "vue";
import { isRef as D } from "vue";
import { ElMessage as G } from "element-plus";
import "./components/common-material-info.vue.js";
import "./components/descriptions-material-info.vue.js";
import "../../../../../../../../modules/index-330e9f5e.js";
const ae = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(_, { emit: x }) {
  const m = x, a = _, y = d(() => {
    switch (a.basicClass) {
      case o.STEEL_PLATE.V:
        return S;
      case o.SECTION_STEEL.V:
        return F;
      case o.STEEL_COIL.V:
        return I;
      case o.MATERIAL.V:
        return p;
      case o.OTHER.V:
        return j;
      case o.GAS.V:
        return N;
      default:
        return p;
    }
  }), e = f(), i = f(false), { visible: l, handleClose: c } = A({ emit: m, props: a, field: "visible", showHook: H }), { outboundCfg: C, partyAOutboundTypeOptions: V } = B();
  b("outboundCfg", C), b("partyAOutboundTypeOptions", V);
  const r = d(() => {
    var t;
    return (t = e.value) == null ? void 0 : t.enlargeWth;
  }), { maxHeight: w } = M({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, r);
  function E() {
    e.value && e.value.resetForm();
  }
  function T() {
    e.value && e.value.clearValidate();
  }
  function H() {
    W(() => {
      T();
    });
  }
  async function O() {
    try {
      i.value = true, await e.value.submit(), G.success("已加入出库清单"), m("success"), c(), E();
    } catch (t) {
      console.log("出库办理", t);
    } finally {
      i.value = false;
    }
  }
  return (t, s) => {
    const k = g("common-button"), L = g("common-dialog");
    return h(), v(L, { modelValue: u(l), "onUpdate:modelValue": s[0] || (s[0] = (R) => D(l) ? l.value = R : null), "before-close": u(c), "show-close": true, top: r.value ? "5vh" : "10vh", width: r.value ? "95%" : "855px", "custom-class": "wms-outbound-handling", title: "出库办理" }, { titleRight: n(() => [P(k, { loading: i.value, size: "default", type: "primary", onClick: O }, { default: n(() => s[1] || (s[1] = [q(" 提 交")])), _: 1, __: [1] }, 8, ["loading"])]), default: n(() => [(h(), v(z(y.value), { ref_key: "outboundFormRef", ref: e, "basic-class": a.basicClass, material: a.material, "max-height": u(w) }, null, 8, ["basic-class", "material", "max-height"]))]), _: 1 }, 8, ["modelValue", "before-close", "top", "width"]);
  };
} };
export {
  ae as default
};
