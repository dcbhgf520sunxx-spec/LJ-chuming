import { bl as o, u as R, jY as B, o as F } from "../../../../../../shared/runtime.js";
import M from "./module/steel-plate.vue.js";
import S from "./module/section-steel.vue.js";
import A from "./module/steel-coil.vue.js";
import d from "./module/aux-mat.vue.js";
import I from "./module/gas.vue.js";
import N from "./module/other.vue.js";
import { computed as f } from "vue";
import { ref as p } from "vue";
import { provide as O } from "vue";
import { nextTick as j } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as g } from "vue";
import { createBlock as h } from "vue";
import { withCtx as n } from "vue";
import { createVNode as W } from "vue";
import { createTextVNode as z } from "vue";
import { resolveDynamicComponent as P } from "vue";
import { unref as u } from "vue";
import { isRef as q } from "vue";
import { ElMessage as D } from "element-plus";
import "./components/common-form-item.vue.js";
import "../../../../../../modules/workshop-select-210dd661.js";
import "./components/common-material-info.vue.js";
import "./components/descriptions-material-info.vue.js";
import "../../../../../../modules/index-330e9f5e.js";
const se = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(v, { emit: _ }) {
  const m = _, t = v, x = f(() => {
    switch (t.basicClass) {
      case o.STEEL_PLATE.V:
        return M;
      case o.SECTION_STEEL.V:
        return S;
      case o.STEEL_COIL.V:
        return A;
      case o.MATERIAL.V:
        return d;
      case o.OTHER.V:
        return N;
      case o.GAS.V:
        return I;
      default:
        return d;
    }
  }), e = p(), i = p(false), { visible: r, handleClose: c } = R({ emit: m, props: t, field: "visible", showHook: y }), { outboundCfg: C } = B();
  O("outboundCfg", C);
  const l = f(() => {
    var a;
    return (a = e.value) == null ? void 0 : a.enlargeWth;
  }), { maxHeight: V } = F({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, l);
  function w() {
    e.value && e.value.resetForm();
  }
  function E() {
    e.value && e.value.clearValidate();
  }
  function y() {
    j(() => {
      E();
    });
  }
  async function H() {
    try {
      i.value = true, await e.value.submit(), D.success(`${t.material.isFreeze ? "已加入冻结列表" : "已加入出库清单"}`), m("success"), c(), w();
    } catch (a) {
      console.log("出库办理", a);
    } finally {
      i.value = false;
    }
  }
  return (a, s) => {
    const T = b("common-button"), k = b("common-dialog");
    return g(), h(k, { modelValue: u(r), "onUpdate:modelValue": s[0] || (s[0] = (L) => q(r) ? r.value = L : null), "before-close": u(c), "show-close": true, top: l.value ? "5vh" : "10vh", width: l.value ? "95%" : "855px", "custom-class": "wms-outbound-handling", title: "出库办理" }, { titleRight: n(() => [W(T, { loading: i.value, size: "default", type: "primary", onClick: H }, { default: n(() => s[1] || (s[1] = [z(" 提 交")])), _: 1, __: [1] }, 8, ["loading"])]), default: n(() => [(g(), h(P(x.value), { ref_key: "outboundFormRef", ref: e, "basic-class": t.basicClass, material: t.material, "max-height": u(V) }, null, 8, ["basic-class", "material", "max-height"]))]), _: 1 }, 8, ["modelValue", "before-close", "top", "width"]);
  };
} };
export {
  se as default
};
