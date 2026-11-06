import B from "moment";
import { ref as p } from "vue";
import { watch as E } from "vue";
import { openBlock as _ } from "vue";
import { createElementBlock as Q } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { withDirectives as f } from "vue";
import { createBlock as S } from "vue";
import { withCtx as n } from "vue";
import { vShow as V } from "vue";
import { Fragment as Y } from "vue";
import { ElDatePicker as k } from "element-plus";
import { ElCol as I } from "element-plus";
import { ElRow as N } from "element-plus";
import { ElInput as P } from "element-plus";
import { vLoading as b } from "element-plus";
import { g as q } from "../../../../../modules/project-plan-a5233e17.js";
import { _ as F, B as O, C as j } from "../../../../../shared/runtime.js";
import { P as t } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const D = { class: "head-extra-wrapper" }, H = { __name: "header", setup(L, { expose: y }) {
  y({ fetchSummary: i });
  const g = { year: B().year().toString(), noOrName: void 0 }, l = p({}), u = p(false), { crud: d, query: r } = O(g);
  E(() => r.year, () => {
    i();
  }, { immediate: true });
  async function i() {
    try {
      u.value = true;
      const s = await q();
      l.value = s || {};
    } catch (s) {
      console.log("获取任务汇总列表失败", s);
    } finally {
      u.value = false;
    }
  }
  return (s, c) => {
    const h = k, o = I, x = N, C = P, w = b;
    return _(), Q(Y, null, [v("div", D, [e(h, { modelValue: a(r).year, "onUpdate:modelValue": c[0] || (c[0] = (m) => a(r).year = m), type: "year", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: a(d).toQuery }, null, 8, ["modelValue", "onChange"]), f((_(), S(x, { gutter: 20, class: "panel-group" }, { default: n(() => [e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "项目总数", "text-color": "#626262", "num-color": "#FCC90B", "end-val": l.value.quantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "自营项目", "text-color": "#626262", "num-color": "#337ECC", "end-val": l.value.selfSupportQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "合营项目", "text-color": "#626262", "num-color": "#337ECC", "end-val": l.value.jointVentureQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "内包制项目", "text-color": "#626262", "num-color": "#337ECC", "end-val": l.value.lumpSumSystemQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "年度已完工项目", "text-color": "#626262", "num-color": "#529B2E", "end-val": l.value.annualCompletedProjectsQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "年度已结算项目", "text-color": "#626262", "num-color": "#529B2E", "end-val": l.value.annualSettledItemsQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "本月新增项目", "text-color": "#626262", "num-color": "#67C23A", "end-val": l.value.newItemsThisMonthQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(o, { span: 3, class: "card-panel-col" }, { default: n(() => [e(a(t), { name: "未创建计划", "text-color": "#626262", "num-color": "#F56C6C", "end-val": l.value.uncreatedPlanQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[w, u.value]])]), f(v("div", null, [e(C, { modelValue: a(r).noOrName, "onUpdate:modelValue": c[1] || (c[1] = (m) => a(r).noOrName = m), size: "default", placeholder: "输入合同编号或项目简称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: a(d).toQuery }, null, 8, ["modelValue", "onBlur"]), e(a(j))], 512), [[V, a(d).searchToggle]])], 64);
  };
} }, R = F(H, [["__scopeId", "data-v-37531aaf"]]);
export {
  R as default
};
