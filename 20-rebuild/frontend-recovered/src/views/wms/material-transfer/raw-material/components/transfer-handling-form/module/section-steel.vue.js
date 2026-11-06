import { unref as s } from "vue";
import { openBlock as i } from "vue";
import { createBlock as u } from "vue";
import { withCtx as a } from "vue";
import { createVNode as r } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as f } from "vue";
import { ElFormItem as d } from "element-plus";
import { sQ as p } from "../../../../../../../shared/runtime.js";
import _ from "../components/common-material-info.vue.js";
const g = { __name: "section-steel", props: { basicClass: { type: Number }, material: { type: Object } }, setup(e) {
  const o = e, { loaded: m, baseUnit: c } = p(o.basicClass);
  return (b, h) => {
    const t = d;
    return s(m) ? (i(), u(_, { key: 0, material: e.material }, { afterSpec: a(() => [r(t, { label: "定尺长度" }, { default: a(() => [l("span", null, n(`${e.material.length}${s(c).length.unit}`), 1)]), _: 1 })]), afterBrand: a(() => [r(t, { label: "炉批号/卷号" }, { default: a(() => [l("span", null, n(e.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"])) : f("", true);
  };
} };
export {
  g as default
};
