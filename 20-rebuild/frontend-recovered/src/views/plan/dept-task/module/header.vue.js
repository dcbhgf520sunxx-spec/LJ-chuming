import x from "moment";
import { ref as m } from "vue";
import { watch as Y } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as V } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withDirectives as _ } from "vue";
import { createBlock as B } from "vue";
import { withCtx as o } from "vue";
import { vShow as E } from "vue";
import { createElementVNode as Q } from "vue";
import { withKeys as b } from "vue";
import { Fragment as k } from "vue";
import { ElDatePicker as P } from "element-plus";
import { ElCol as S } from "element-plus";
import { ElRow as D } from "element-plus";
import { ElInput as I } from "element-plus";
import { vLoading as L } from "element-plus";
import { g as T } from "../../../../modules/dept-task-1cfc3d1d.js";
import { _ as q, B as F, C as K } from "../../../../shared/runtime.js";
import { P as r } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const H = { __name: "header", setup(M) {
  const f = { year: x().year().toString() }, { crud: u, query: l } = F(f), d = m(false), t = m({});
  function v(n) {
    return n > /* @__PURE__ */ new Date();
  }
  Y(() => l.year, () => {
    y();
  }, { immediate: true });
  async function y() {
    try {
      d.value = true;
      const n = await T({ year: l.year });
      t.value = n;
    } catch (n) {
      console.log(n);
    } finally {
      d.value = false;
    }
  }
  return (n, c) => {
    const g = P, s = S, h = D, w = I, C = L;
    return p(), V(k, null, [e(g, { modelValue: a(l).year, "onUpdate:modelValue": c[0] || (c[0] = (i) => a(l).year = i), type: "year", size: "small", class: "date-item filter-item", style: { width: "120px !important" }, format: "YYYY", "value-format": "YYYY", placeholder: "选择年", "disabled-date": v, onChange: a(u).toQuery }, null, 8, ["modelValue", "onChange"]), _((p(), B(h, { gutter: 20, class: "panel-group" }, { default: o(() => [e(s, { span: 5, class: "card-panel-col" }, { default: o(() => [e(a(r), { name: "项目总数", "text-color": "#626262", "num-color": "#FCC90B", "end-val": t.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 5, class: "card-panel-col" }, { default: o(() => [e(a(r), { name: "执行中", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.processingQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 5, class: "card-panel-col" }, { default: o(() => [e(a(r), { name: "年度已完成项目", "text-color": "#626262", "num-color": "#529B2E", "end-val": t.value.annualCompletedProjectsQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 5, class: "card-panel-col" }, { default: o(() => [e(a(r), { name: "本月新增项目", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.newItemsThisMonthQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 4, class: "card-panel-col" }, { default: o(() => [e(a(r), { name: "未创建负责人", "text-color": "#626262", "num-color": "#F56C6C", "end-val": t.value.uncreatedPersonQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[C, d.value]]), _(Q("div", null, [e(w, { modelValue: a(l).name, "onUpdate:modelValue": c[1] || (c[1] = (i) => a(l).name = i), modelModifiers: { trim: true }, placeholder: "按项目搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: b(a(u).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), e(a(K))], 512), [[E, a(u).searchToggle]])], 64);
  };
} }, R = q(H, [["__scopeId", "data-v-4f058c33"]]);
export {
  R as default
};
