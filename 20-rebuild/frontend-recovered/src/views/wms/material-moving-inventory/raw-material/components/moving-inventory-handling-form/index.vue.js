import { bl as o, u as S, jY as B, o as M } from "../../../../../../shared/runtime.js";
import A from "./module/steel-plate.vue.js";
import F from "./module/section-steel.vue.js";
import N from "./module/steel-coil.vue.js";
import p from "./module/aux-mat.vue.js";
import I from "./module/gas.vue.js";
import O from "./module/other.vue.js";
import { useStore as j } from "vuex";
import { computed as d } from "vue";
import { ref as f } from "vue";
import { provide as W } from "vue";
import { nextTick as P } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as h } from "vue";
import { createBlock as g } from "vue";
import { withCtx as n } from "vue";
import { createVNode as q } from "vue";
import { createTextVNode as z } from "vue";
import { resolveDynamicComponent as D } from "vue";
import { unref as u } from "vue";
import { isRef as G } from "vue";
import { ElMessage as U } from "element-plus";
import "../../../../../../modules/application-0ee072a2.js";
import "./components/common-form-item.vue.js";
import "../../../../../../modules/workshop-select-210dd661.js";
import "./components/common-material-info.vue.js";
import "./components/descriptions-material-info.vue.js";
import "../../../../../../modules/index-330e9f5e.js";
const le = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(v, { emit: _ }) {
  const x = j(), m = _, a = v, C = d(() => {
    switch (a.basicClass) {
      case o.STEEL_PLATE.V:
        return A;
      case o.SECTION_STEEL.V:
        return F;
      case o.STEEL_COIL.V:
        return N;
      case o.MATERIAL.V:
        return p;
      case o.OTHER.V:
        return O;
      case o.GAS.V:
        return I;
      default:
        return p;
    }
  }), e = f(), i = f(false), { visible: r, handleClose: c } = S({ emit: m, props: a, field: "visible", showHook: H }), { outboundCfg: V } = B();
  W("outboundCfg", V);
  const l = d(() => {
    var t;
    return (t = e.value) == null ? void 0 : t.enlargeWth;
  }), { maxHeight: w } = M({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, l);
  function E() {
    e.value && e.value.resetForm();
  }
  function y() {
    e.value && e.value.clearValidate();
  }
  function H() {
    P(() => {
      y();
    });
  }
  async function T() {
    try {
      i.value = true, await e.value.submit(), U.success("已加入移库审核列表"), await x.dispatch("approval_list/fetchApprovalNum"), m("success"), c(), E();
    } catch (t) {
      console.log("出库办理", t);
    } finally {
      i.value = false;
    }
  }
  return (t, s) => {
    const k = b("common-button"), L = b("common-dialog");
    return h(), g(L, { modelValue: u(r), "onUpdate:modelValue": s[0] || (s[0] = (R) => G(r) ? r.value = R : null), "before-close": u(c), "show-close": true, top: l.value ? "5vh" : "10vh", width: l.value ? "95%" : "855px", "custom-class": "wms-outbound-handling", title: "移库办理" }, { titleRight: n(() => [q(k, { loading: i.value, size: "default", type: "primary", onClick: T }, { default: n(() => s[1] || (s[1] = [z(" 提 交")])), _: 1, __: [1] }, 8, ["loading"])]), default: n(() => [(h(), g(D(C.value), { ref_key: "outboundFormRef", ref: e, "basic-class": a.basicClass, material: a.material, "max-height": u(w) }, null, 8, ["basic-class", "material", "max-height"]))]), _: 1 }, 8, ["modelValue", "before-close", "top", "width"]);
  };
} };
export {
  le as default
};
