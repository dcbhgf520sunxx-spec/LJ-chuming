import Y from "moment";
import { ref as i } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as o } from "vue";
import { unref as a } from "vue";
import { withDirectives as N } from "vue";
import { createBlock as V } from "vue";
import { withCtx as s } from "vue";
import { Fragment as B } from "vue";
import { ElDatePicker as b } from "element-plus";
import { ElCol as k } from "element-plus";
import { ElRow as E } from "element-plus";
import { ElInput as I } from "element-plus";
import { vLoading as j } from "element-plus";
import { a as O } from "../../../../modules/sectional-entry-plan-49cfc1e2.js";
import { _ as P, B as Q, C as q } from "../../../../shared/runtime.js";
import { P as d } from "../../../../modules/index-5b9e6004.js";
import "../../../../modules/vue3-count-to.esm-8987f38d.js";
const A = { class: "head-extra-wrapper" }, D = { __name: "header", setup(F, { expose: f }) {
  const v = { year: Y().year().toString(), projectNoOrName: void 0 }, l = i({}), c = i(false), { crud: p, query: t } = Q(v);
  async function y() {
    try {
      c.value = true;
      const n = await O(t);
      l.value = n || {};
    } catch (n) {
      console.log(n);
    } finally {
      c.value = false;
    }
  }
  return f({ fetchCountInfo: y }), (n, r) => {
    const C = b, u = k, g = E, h = I, x = j;
    return m(), w(B, null, [_("div", A, [o(C, { modelValue: a(t).year, "onUpdate:modelValue": r[0] || (r[0] = (e) => a(t).year = e), type: "year", class: "date-item filter-item", style: { width: "100px !important" }, placeholder: "选择年", format: "YYYY", "value-format": "YYYY", onChange: a(p).toQuery }, null, 8, ["modelValue", "onChange"]), N((m(), V(g, { gutter: 20, class: "panel-group" }, { default: s(() => [o(u, { span: 8, class: "card-panel-col" }, { default: s(() => {
      var e;
      return [o(a(d), { name: "项目总数", "text-color": "#626262", "num-color": "#67C23A", "end-val": ((e = l.value) == null ? void 0 : e.projectCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(u, { span: 8, class: "card-panel-col" }, { default: s(() => {
      var e;
      return [o(a(d), { name: "已创建计划", "text-color": "#626262", "num-color": "#67C23A", "end-val": ((e = l.value) == null ? void 0 : e.createdCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 }), o(u, { span: 8, class: "card-panel-col" }, { default: s(() => {
      var e;
      return [o(a(d), { name: "未创建计划", "text-color": "#626262", "num-color": "#F56C6C", "end-val": ((e = l.value) == null ? void 0 : e.notCreatedCount) || 0, precision: 0 }, null, 8, ["end-val"])];
    }), _: 1 })]), _: 1 })), [[x, c.value]])]), _("div", null, [o(h, { modelValue: a(t).projectNoOrName, "onUpdate:modelValue": r[1] || (r[1] = (e) => a(t).projectNoOrName = e), placeholder: "输入合同编号或项目简称", style: { width: "200px" }, class: "filter-item", clearable: "", onBlur: a(p).toQuery }, null, 8, ["modelValue", "onBlur"]), o(a(q))])], 64);
  };
} }, $ = P(D, [["__scopeId", "data-v-d160b73c"]]);
export {
  $ as default
};
