import { ref as b } from "vue";
import { ElMessage as O } from "element-plus";
import { ElMessageBox as U } from "element-plus";
import { resolveComponent as g } from "vue";
import { openBlock as f } from "vue";
import { createBlock as L } from "vue";
import { withCtx as p } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { createTextVNode as z } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as D } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as C } from "vue";
import { renderList as N } from "vue";
import { createCommentVNode as $ } from "vue";
import { withDirectives as V } from "vue";
import { vShow as k } from "vue";
import { ElFormItem as j } from "element-plus";
import { ElForm as M } from "element-plus";
import { _ as K, dM as S, ao as H, i as P, b as G, aK as J, a9 as Q } from "../../../../../../shared/runtime.js";
import { _ as W } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const X = { class: "process-container" }, Y = { class: "process-box" }, Z = { __name: "form", setup(ee) {
  const h = b(), T = b([]), E = S.ARTIFACT.V, F = { id: void 0, processSequenceIds: [void 0] }, r = b({}), { crud: d, form: e, CRUD: I } = H(F, h), w = { processSequenceIds: [{ required: true, message: "请选择工序" }] };
  function B(n, a) {
    return n.filter((c) => c !== a);
  }
  function x() {
    e.processSequenceIds.push(void 0);
  }
  function R(n) {
    e.processSequenceIds.splice(n, 1), r.value[e.processSequenceIds[e.processSequenceIds.length - 1]] = void 0;
  }
  return I.HOOK.beforeToCU = () => {
    var n;
    (n = e.processSequenceIds) != null && n.length || (e.processSequenceIds = [void 0]), P(e.processSequenceObj) ? r.value = e.processSequenceObj : r.value = {}, e.productType = S.ARTIFACT.V;
  }, I.HOOK.afterValidateCU = () => {
  }, I.HOOK.beforeSubmit = async () => {
    var m, y;
    if (e.processSequenceIds.length === 1 && G(e.processSequenceIds[0])) return e.typeId = e.id, true;
    const n = J(e.processSequenceIds), a = await T.value[0].getSourceData(), c = Q(a.value, "id");
    let u = -1, i = true;
    for (let s = 0; s < e.processSequenceIds.length; s++) {
      const t = e.processSequenceIds[s];
      if (u === -1 && ((m = c[t]) == null ? void 0 : m.productType) & S.ARTIFACT.V && (u = s), u !== -1 && ((y = c[t]) == null ? void 0 : y.productType) & S.ASSEMBLE.V) {
        i = false;
        break;
      }
    }
    if (!i) return O({ message: "请正确填写工序次序，部件工序必选在构件工序前！", type: "error" }), false;
    const q = e.processSequenceIds.map((s) => `【${c[s].name}】${r.value[s] ? "→ " + r.value[s] + "天 " : ""}`).join("→");
    try {
      await U.confirm(`“${e.classificationName}”的工序为：
${q}
${n ? "检测到重复工序，" : ""}确认提交？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const s = [];
      return e.processSequenceIds.forEach((t, A) => {
        s.push({ id: t, nodeTime: r.value[t] || 0, sequence: A });
      }), e.processLinkList = s, e.typeId = e.id, true;
    } catch {
      return false;
    }
  }, (n, a) => {
    const c = g("common-button"), u = j, i = g("common-input-number"), q = M, m = g("common-dialog");
    return f(), L(m, { "append-to-body": "", "close-on-click-modal": false, "before-close": o(d).cancelCU, visible: o(d).status.cu > 0, title: o(d).status.title, width: "500px" }, { titleRight: p(() => [l(c, { loading: o(d).status.cu === 2, type: "primary", size: "default", onClick: o(d).submitCU }, { default: p(() => a[0] || (a[0] = [z("确认")])), _: 1, __: [0] }, 8, ["loading", "onClick"])]), default: p(() => [l(q, { ref_key: "formRef", ref: h, model: o(e), rules: w, size: "default", "label-width": "90px" }, { default: p(() => [l(u, { label: "构件类型" }, { default: p(() => [_("span", null, D(o(e).classificationName), 1)]), _: 1 }), l(u, { label: "工序", prop: "processSequenceIds" }, { default: p(() => [_("div", X, [_("div", Y, [(f(true), v(C, null, N(o(e).processSequenceIds, (y, s) => (f(), v("div", { key: s, class: "process-drawer" }, [l(o(W), { ref_for: true, ref: (t) => T.value[s] = t, modelValue: o(e).processSequenceIds[s], "onUpdate:modelValue": (t) => o(e).processSequenceIds[s] = t, size: "default", multiple: false, clearable: true, productionLineTypeEnum: o(e).productionLineTypeEnum, "product-type": o(E), style: { width: "180px" }, class: "input-underline", "disabled-value": B(o(e).processSequenceIds, o(e).processSequenceIds[s]) }, null, 8, ["modelValue", "onUpdate:modelValue", "productionLineTypeEnum", "product-type", "disabled-value"]), s !== o(e).processSequenceIds.length - 1 ? (f(), v(C, { key: 0 }, [l(i, { modelValue: r.value[o(e).processSequenceIds[s]], "onUpdate:modelValue": (t) => r.value[o(e).processSequenceIds[s]] = t, step: 1, controls: false, placeholder: "耗时", min: 0, max: 99, size: "default", class: "input-underline", style: { width: "60px", "margin-left": "3px" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), a[1] || (a[1] = _("span", { style: { "margin-left": "3px" } }, "天", -1))], 64)) : $("", true), V(l(c, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "10px" }, onClick: (t) => R(s) }, null, 8, ["onClick"]), [[k, o(e).processSequenceIds && o(e).processSequenceIds.length > 1]]), V(l(c, { icon: "el-icon-plus", size: "default", type: "success", onClick: x }, null, 512), [[k, s === o(e).processSequenceIds.length - 1]])]))), 128))])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, re = K(Z, [["__scopeId", "data-v-66122201"]]);
export {
  re as default
};
