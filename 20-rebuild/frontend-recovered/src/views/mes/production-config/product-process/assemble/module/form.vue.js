import { ref as I } from "vue";
import { ElMessageBox as O } from "element-plus";
import { resolveComponent as b } from "vue";
import { openBlock as f } from "vue";
import { createBlock as U } from "vue";
import { withCtx as d } from "vue";
import { createVNode as a } from "vue";
import { unref as s } from "vue";
import { createTextVNode as E } from "vue";
import { createElementVNode as _ } from "vue";
import { toDisplayString as T } from "vue";
import { createElementBlock as y } from "vue";
import { Fragment as h } from "vue";
import { renderList as z } from "vue";
import { createCommentVNode as D } from "vue";
import { withDirectives as k } from "vue";
import { vShow as C } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElForm as R } from "element-plus";
import { _ as $, ao as j, i as L, dM as N, b as K, aK as M, a9 as H } from "../../../../../../shared/runtime.js";
import { _ as A } from "../../../../../../modules/process-select-b35dffc0.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../../modules/use-process-af1f8c99.js";
const P = { class: "process-container" }, G = { class: "process-box" }, J = { __name: "form", setup(Q) {
  const v = I(), g = I([]), V = { id: void 0, processSequenceIds: [void 0] }, r = I({}), { crud: p, form: e, CRUD: S } = j(V, v);
  function w(t, c) {
    return t.filter((l) => l !== c);
  }
  function B() {
    e.processSequenceIds.push(void 0);
  }
  function x(t) {
    e.processSequenceIds.splice(t, 1);
  }
  return S.HOOK.beforeToCU = () => {
    var t;
    (t = e.processSequenceIds) != null && t.length || (e.processSequenceIds = [void 0]), L(e.processSequenceObj) ? r.value = e.processSequenceObj : r.value = {}, e.productType = N.ASSEMBLE.V;
  }, S.HOOK.afterValidateCU = () => {
  }, S.HOOK.beforeSubmit = async () => {
    if (e.processSequenceIds.length === 1 && K(e.processSequenceIds[0])) return e.typeId = e.id, true;
    const t = M(e.processSequenceIds), c = await g.value[0].getSourceData(), l = H(c.value, "id"), i = e.processSequenceIds.map((n) => `【${l[n].name}】${r.value[n] ? "→ " + r.value[n] + "天 " : ""}`).join("→");
    try {
      await O.confirm(`“${e.name}”的工序为：
${i}
${t ? "检测到重复工序，" : ""}确认提交？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const n = [];
      return e.processSequenceIds.forEach((m, q) => {
        n.push({ id: m, nodeTime: r.value[m] || 0, sequence: q });
      }), e.processLinkList = n, e.typeId = e.id, true;
    } catch {
      return false;
    }
  }, (t, c) => {
    const l = b("common-button"), i = F, n = b("common-input-number"), m = R, q = b("common-dialog");
    return f(), U(q, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(p).cancelCU, visible: s(p).status.cu > 0, title: s(p).status.title, width: "500px" }, { titleRight: d(() => [a(l, { loading: s(p).status.cu === 2, type: "primary", size: "default", onClick: s(p).submitCU }, { default: d(() => c[0] || (c[0] = [E("确认")])), _: 1, __: [0] }, 8, ["loading", "onClick"])]), default: d(() => [a(m, { ref_key: "formRef", ref: v, model: s(e), size: "default", "label-width": "90px" }, { default: d(() => [a(i, { label: "部件类型" }, { default: d(() => [_("span", null, T(s(e).name), 1)]), _: 1 }), a(i, { label: "工序", prop: "processSequenceIds" }, { default: d(() => [_("div", P, [_("div", G, [(f(true), y(h, null, z(s(e).processSequenceIds, (W, o) => (f(), y("div", { key: o, class: "process-drawer" }, [a(s(A), { ref_for: true, ref: (u) => g.value[o] = u, modelValue: s(e).processSequenceIds[o], "onUpdate:modelValue": (u) => s(e).processSequenceIds[o] = u, size: "default", multiple: false, clearable: true, "product-type": s(e).productType, style: { width: "180px" }, class: "input-underline", "disabled-value": w(s(e).processSequenceIds, s(e).processSequenceIds[o]) }, null, 8, ["modelValue", "onUpdate:modelValue", "product-type", "disabled-value"]), o !== s(e).processSequenceIds.length - 1 ? (f(), y(h, { key: 0 }, [a(n, { modelValue: r.value[s(e).processSequenceIds[o]], "onUpdate:modelValue": (u) => r.value[s(e).processSequenceIds[o]] = u, step: 1, controls: false, placeholder: "耗时", min: 0, max: 99, size: "default", class: "input-underline", style: { width: "60px", "margin-left": "3px" } }, null, 8, ["modelValue", "onUpdate:modelValue"]), c[1] || (c[1] = _("span", { style: { "margin-left": "3px" } }, "天", -1))], 64)) : D("", true), k(a(l, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "10px" }, onClick: (u) => x(o) }, null, 8, ["onClick"]), [[C, s(e).processSequenceIds && s(e).processSequenceIds.length > 1]]), k(a(l, { icon: "el-icon-plus", size: "default", type: "success", onClick: B }, null, 512), [[C, o === s(e).processSequenceIds.length - 1]])]))), 128))])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, oe = $(J, [["__scopeId", "data-v-f07df702"]]);
export {
  oe as default
};
