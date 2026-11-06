import { ref as b } from "vue";
import { ElMessageBox as R } from "element-plus";
import { resolveComponent as q } from "vue";
import { openBlock as m } from "vue";
import { createBlock as V } from "vue";
import { withCtx as d } from "vue";
import { createVNode as l } from "vue";
import { unref as s } from "vue";
import { createTextVNode as x } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as D } from "vue";
import { createElementBlock as v } from "vue";
import { Fragment as E } from "vue";
import { renderList as F } from "vue";
import { withDirectives as h } from "vue";
import { vShow as C } from "vue";
import { ElFormItem as z } from "element-plus";
import { ElForm as U } from "element-plus";
import { _ as $, ao as N, aD as A, aN as O, aK as P, a9 as j } from "../../../../../../shared/runtime.js";
import { u as H } from "../../../../../../modules/use-bridge-process-6f90ba68.js";
import { _ as K } from "../../../../../../modules/process-select-cf7cf476.js";
import "../../../../../../modules/raf-ac2cc4f2.js";
const L = { class: "process-container" }, M = { class: "process-box" }, G = { __name: "form", setup(J) {
  const { process: _ } = H(), y = b(), S = b([]), k = { id: void 0, processSequenceIds: [void 0] }, { crud: p, form: e, CRUD: I } = N(k, y);
  function T(o, r) {
    return o.filter((t) => t !== r);
  }
  function w() {
    e.processSequenceIds.push(void 0);
  }
  function B(o) {
    e.processSequenceIds.splice(o, 1);
  }
  return I.HOOK.beforeToCU = () => {
    var r, t, n;
    (r = e.processSequenceIds) != null && r.length || (e.processSequenceIds = [void 0]), e.productType = A.MACHINE_PART.V;
    const o = ((t = _.value) == null ? void 0 : t.length) && ((n = _.value) == null ? void 0 : n.filter((u) => u.productType && u.productType & e.productType)) || [];
    o != null && o.length && (e.processSequenceIds[0] = o[0].id);
  }, I.HOOK.beforeSubmit = async () => {
    const o = O(e.processSequenceIds), r = P(o), t = await S.value[0].getSourceData(), n = j(t.value, "id"), u = o.map((a) => `【${n[a].name}】`).join("→");
    try {
      await R.confirm(`“${e.name}”的工序为：
${u || "-"}
${r ? "检测到重复工序，" : ""}确认提交？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const a = [];
      return o.forEach((g, c) => {
        a.push({ id: g, nodeTime: 0, sequence: c });
      }), console.log(o, "_processSequenceIds"), e.processLinkList = a, e.typeId = e.id, true;
    } catch {
      return false;
    }
  }, (o, r) => {
    const t = q("common-button"), n = z, u = U, a = q("common-dialog");
    return m(), V(a, { "append-to-body": "", "close-on-click-modal": false, "before-close": s(p).cancelCU, visible: s(p).status.cu > 0, title: s(p).status.title, width: "500px" }, { titleRight: d(() => [l(t, { loading: s(p).status.cu === 2, type: "primary", size: "default", onClick: s(p).submitCU }, { default: d(() => r[0] || (r[0] = [x("确认")])), _: 1, __: [0] }, 8, ["loading", "onClick"])]), default: d(() => [l(u, { ref_key: "formRef", ref: y, model: s(e), size: "default", "label-width": "90px" }, { default: d(() => [l(n, { label: "零件类型" }, { default: d(() => [f("span", null, D(s(e).name), 1)]), _: 1 }), l(n, { label: "工序", prop: "processSequenceIds" }, { default: d(() => [f("div", L, [f("div", M, [(m(true), v(E, null, F(s(e).processSequenceIds, (g, c) => (m(), v("div", { key: c, class: "process-drawer" }, [l(s(K), { ref_for: true, ref: (i) => S.value[c] = i, modelValue: s(e).processSequenceIds[c], "onUpdate:modelValue": (i) => s(e).processSequenceIds[c] = i, size: "default", multiple: false, clearable: true, "product-type": s(e).productType, style: { width: "220px" }, "disabled-value": T(s(e).processSequenceIds, s(e).processSequenceIds[c]) }, null, 8, ["modelValue", "onUpdate:modelValue", "product-type", "disabled-value"]), h(l(t, { icon: "el-icon-delete", size: "default", type: "danger", style: { "margin-left": "3px" }, onClick: (i) => B(c) }, null, 8, ["onClick"]), [[C, s(e).processSequenceIds && s(e).processSequenceIds.length > 1 && c > 0]]), h(l(t, { icon: "el-icon-plus", size: "default", type: "success", onClick: w }, null, 512), [[C, c === s(e).processSequenceIds.length - 1]])]))), 128))])])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, ee = $(G, [["__scopeId", "data-v-ed608307"]]);
export {
  ee as default
};
