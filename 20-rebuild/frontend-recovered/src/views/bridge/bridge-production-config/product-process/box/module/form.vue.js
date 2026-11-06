import { ref as q } from "vue";
import { ElMessageBox as D } from "element-plus";
import { resolveComponent as b } from "vue";
import { openBlock as f } from "vue";
import { createBlock as O } from "vue";
import { withCtx as p } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import { createTextVNode as T } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as U } from "vue";
import { createElementBlock as I } from "vue";
import { Fragment as h } from "vue";
import { renderList as z } from "vue";
import { createCommentVNode as F } from "vue";
import { withDirectives as k } from "vue";
import { vShow as C } from "vue";
import { ElFormItem as R } from "element-plus";
import { ElForm as $ } from "element-plus";
import { _ as j, ao as E, i as N, aD as K, b as L, aK as P, a9 as H } from "../../../../../../shared/runtime.js";
import { _ as A } from "../../../../../../modules/process-select-cf7cf476.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-bridge-process-6f90ba68.js";
const M = { class: "process-container" }, X = { class: "process-box" }, G = { __name: "form", setup(J) {
  const y = q(), v = q([]), V = { id: void 0, processSequenceIds: [void 0] }, r = q({}), { crud: d, form: e, CRUD: g } = E(V, y);
  function w(t, c) {
    return t.filter((l) => l !== c);
  }
  function B() {
    e.processSequenceIds.push(void 0);
  }
  function x(t) {
    e.processSequenceIds.splice(t, 1);
  }
  return g.HOOK.beforeToCU = () => {
    var t;
    (t = e.processSequenceIds) != null && t.length || (e.processSequenceIds = [void 0]), N(e.processSequenceObj) ? r.value = e.processSequenceObj : r.value = {}, e.productType = K.BOX.V;
  }, g.HOOK.beforeSubmit = async () => {
    if (e.processSequenceIds.length === 1 && L(e.processSequenceIds[0])) return e.typeId = e.id, true;
    const t = P(e.processSequenceIds), c = await v.value[0].getSourceData(), l = H(c.value, "id"), i = e.processSequenceIds.map((n) => `【${l[n].name}】${r.value[n] ? "→ " + r.value[n] + "天 " : ""}`).join("→");
    try {
      await D.confirm(`“${e.name}”的工序为：
${i}
${t ? "检测到重复工序，" : ""}确认提交？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const n = [];
      return e.processSequenceIds.forEach((m, S) => {
        n.push({ id: m, nodeTime: r.value[m] || 0, sequence: S });
      }), e.processLinkList = n, e.typeId = e.id, true;
    } catch {
      return false;
    }
  }, (t, c) => {
    const l = b("common-button"), i = R, n = b("common-input-number"), m = $, S = b("common-dialog");
    return f(), O(S, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(d).cancelCU, visible: s(d).status.cu > 0, title: s(d).status.title, width: "500px" }, { titleRight: p(() => [a(l, { loading: s(d).status.cu === 2, type: "primary", size: "default", onClick: s(d).submitCU }, { default: p(() => c[0] || (c[0] = [T("确认")])), _: 1, __: [0] }, 8, ["loading", "onClick"])]), default: p(() => [a(m, { ref_key: "formRef", ref: y, model: s(e), size: "default", "label-width": "90px" }, { default: p(() => [a(i, { label: "分段类型" }, { default: p(() => [_("span", null, U(s(e).name), 1)]), _: 1 }), a(i, { label: "工序", prop: "processSequenceIds" }, { default: p(() => [_("div", M, [_("div", X, [(f(true), I(h, null, z(s(e).processSequenceIds, (Q, o) => (f(), I("div", { key: o, class: "process-drawer" }, [a(s(A), { ref_for: true, ref: (u) => v.value[o] = u, modelValue: s(e).processSequenceIds[o], "onUpdate:modelValue": (u) => s(e).processSequenceIds[o] = u, size: "default", multiple: false, clearable: true, "product-type": s(e).productType, style: { width: "180px" }, class: "input-underline", "disabled-value": w(s(e).processSequenceIds, s(e).processSequenceIds[o]) }, null, 8, ["modelValue", "onUpdate:modelValue", "product-type", "disabled-value"]), o !== s(e).processSequenceIds.length - 1 ? (f(), I(h, { key: 0 }, [a(n, { modelValue: r.value[s(e).processSequenceIds[o]], "onUpdate:modelValue": (u) => r.value[s(e).processSequenceIds[o]] = u, step: 1, controls: false, placeholder: "耗时", min: 0, max: 99, size: "default", class: "input-underline", style: { width: "60px", "margin-left": "3px" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), c[1] || (c[1] = _("span", { style: { "margin-left": "3px" } }, "天", -1))], 64)) : F("", true), k(a(l, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "10px" }, onClick: (u) => x(o) }, null, 8, ["onClick"]), [[C, s(e).processSequenceIds && s(e).processSequenceIds.length > 1]]), k(a(l, { icon: "el-icon-plus", size: "default", type: "success", onClick: B }, null, 512), [[C, o === s(e).processSequenceIds.length - 1]])]))), 128))])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, oe = j(G, [["__scopeId", "data-v-6fe414ff"]]);
export {
  oe as default
};
