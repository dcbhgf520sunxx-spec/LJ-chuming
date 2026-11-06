import { cJ as s, u as U, jY as D, o as P, gG as f } from "../../../../../../../../shared/runtime.js";
import j from "./module/steel-plate.vue.js";
import W from "./module/section-steel.vue.js";
import z from "./module/steel-coil.vue.js";
import C from "./module/aux-mat.vue.js";
import G from "./module/gas.vue.js";
import q from "./module/other.vue.js";
import { useStore as J } from "vuex";
import { computed as v } from "vue";
import { ref as T } from "vue";
import { provide as V } from "vue";
import { watch as b } from "vue";
import { nextTick as Y } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as g } from "vue";
import { createBlock as h } from "vue";
import { withCtx as r } from "vue";
import { unref as l } from "vue";
import { createTextVNode as x } from "vue";
import { createCommentVNode as K } from "vue";
import { createVNode as Q } from "vue";
import { resolveDynamicComponent as X } from "vue";
import { isRef as Z } from "vue";
import { ElMessage as E } from "element-plus";
import "./components/common-material-info.vue.js";
import "./components/descriptions-material-info.vue.js";
import "../../../../../../../../modules/index-330e9f5e.js";
const ce = { __name: "index", props: { visible: { type: Boolean, require: true }, basicClass: { type: Number }, material: { type: Object } }, emits: ["success", "update:visible"], setup(S, { emit: O }) {
  const _ = J(), c = O, u = S, R = v(() => {
    switch (u.basicClass) {
      case s.STEEL_PLATE.V:
        return j;
      case s.SECTION_STEEL.V:
        return W;
      case s.STEEL_COIL.V:
        return z;
      case s.MATERIAL.V:
        return C;
      case s.OTHER.V:
        return q;
      case s.GAS.V:
        return G;
      default:
        return C;
    }
  }), o = T(), a = T(false), { visible: i, handleClose: m } = U({ emit: c, props: u, field: "visible", showHook: L }), { outboundCfg: k, selfOutboundTypeOptions: H } = D();
  V("outboundCfg", k), V("selfOutboundTypeOptions", H);
  const p = v(() => {
    var e;
    return (e = o.value) == null ? void 0 : e.enlargeWth;
  });
  b(() => {
    var e;
    return (e = o.value) == null ? void 0 : e.form.outboundType;
  }, (e) => {
    var t;
    (t = o.value) == null || t.formInitTwo();
  }, { deep: true });
  const { maxHeight: N } = P({ mainBox: ".wms-outbound-handling", extraBox: [".el-dialog__header", ".plate-out-material-info", ".material-outbound-mode-info", ".form-info", ".other-info"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, navbar: false, minHeight: 300, extraHeight: 200 }, p);
  function d() {
    o.value && o.value.resetForm();
  }
  function I() {
    o.value && o.value.clearValidate();
  }
  const n = v(() => {
    var e;
    return o.value ? (e = o.value) == null ? void 0 : e.outboundTypeSelection : f.PRODUCE.V;
  });
  function L() {
    Y(() => {
      I();
    });
  }
  async function A() {
    try {
      a.value = true, await o.value.auditSubmit(), await _.dispatch("approval_list/fetchApprovalNum"), E.success("已提交审核"), c("success"), m(), d();
    } catch (e) {
      console.log("出库办理提交审核", e);
    } finally {
      a.value = false;
    }
  }
  async function B() {
    try {
      a.value = true, await o.value.commonSubmit(), await _.dispatch("approval_list/fetchApprovalNum"), E.success("已加入出库清单"), c("success"), m(), d();
    } catch (e) {
      console.log("出库办理", e);
    } finally {
      a.value = false;
    }
  }
  return b(() => n.value, (e) => {
    var t;
    (t = o.value) == null || t.formInitTwo();
  }), b(() => i.value, (e) => {
    e && d();
  }), (e, t) => {
    const y = w("common-button"), M = w("common-dialog");
    return g(), h(M, { modelValue: l(i), "onUpdate:modelValue": t[0] || (t[0] = (F) => Z(i) ? i.value = F : null), "before-close": l(m), "show-close": true, top: p.value ? "3vh" : "2vh", width: p.value ? "95%" : "855px", "custom-class": "wms-outbound-handling", title: "出库办理" }, { titleRight: r(() => [n.value && !(n.value === l(f).PRODUCE.V || n.value === l(f).CONSTRUCTION_SITE_USE.V) ? (g(), h(y, { key: 0, loading: a.value, size: "default", type: "primary", onClick: A }, { default: r(() => t[1] || (t[1] = [x(" 提交审核 ")])), _: 1, __: [1] }, 8, ["loading"])) : K("", true), Q(y, { loading: a.value, size: "default", type: "success", onClick: B }, { default: r(() => t[2] || (t[2] = [x("保存至出库清单")])), _: 1, __: [2] }, 8, ["loading"])]), default: r(() => [(g(), h(X(R.value), { ref_key: "outboundFormRef", ref: o, "basic-class": u.basicClass, material: u.material, "max-height": l(N) }, null, 8, ["basic-class", "material", "max-height"]))]), _: 1 }, 8, ["modelValue", "before-close", "top", "width"]);
  };
} };
export {
  ce as default
};
