import { openBlock as y } from "vue";
import { createElementBlock as b } from "vue";
import { createVNode as e } from "vue";
import { unref as n } from "vue";
import { withKeys as p } from "vue";
import { withCtx as a } from "vue";
import { renderSlot as v } from "vue";
import { ElInput as x } from "element-plus";
import { ElCol as N } from "element-plus";
import { ElRow as V } from "element-plus";
import { B as h, C as w } from "../../../../../shared/runtime.js";
import { P as u } from "../../../../../modules/index-5b9e6004.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const C = { class: "head-container" }, g = { __name: "header", props: { summary: { type: Object, default: () => {
} } }, setup(i) {
  const l = i, c = { biddingPlatformName: void 0, informantUserName: void 0 }, { query: t, crud: m } = h(c);
  return (f, o) => {
    const d = x, s = N, _ = V;
    return y(), b("div", C, [e(d, { modelValue: n(t).biddingPlatformName, "onUpdate:modelValue": o[0] || (o[0] = (r) => n(t).biddingPlatformName = r), class: "filter-item", style: { width: "210px" }, placeholder: "招标平台名称搜索", clearable: "", onKeyup: p(n(m).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), e(d, { modelValue: n(t).informantUserName, "onUpdate:modelValue": o[1] || (o[1] = (r) => n(t).informantUserName = r), class: "filter-item", style: { width: "210px" }, placeholder: "登记人搜索", clearable: "", onKeyup: p(n(m).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), e(n(w)), e(_, { gutter: 20 }, { default: a(() => [e(s, { span: 8 }, { default: a(() => [e(n(u), { name: "企业数量", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.summary.enterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 8 }, { default: a(() => [e(n(u), { name: "国内", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.summary.domesticEnterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 }), e(s, { span: 8 }, { default: a(() => [e(n(u), { name: "国外", "text-color": "#626262", "num-color": "#1890ff", "end-val": l.summary.foreignEnterprisesCount || 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 }), v(f.$slots, "printBtn")]);
  };
} };
export {
  g as default
};
