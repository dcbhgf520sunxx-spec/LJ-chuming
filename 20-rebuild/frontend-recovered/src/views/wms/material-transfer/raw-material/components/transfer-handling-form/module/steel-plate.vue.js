import { unref as a } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as t } from "vue";
import { createVNode as n } from "vue";
import { createElementVNode as i } from "vue";
import { toDisplayString as r } from "vue";
import { createCommentVNode as d } from "vue";
import { ElFormItem as f } from "element-plus";
import { sQ as h } from "../../../../../../../shared/runtime.js";
import b from "../components/common-material-info.vue.js";
const C = { __name: "steel-plate", props: { basicClass: { type: Number }, material: { type: Object } }, setup(e) {
  const m = e, { loaded: o, baseUnit: s } = h(m.basicClass);
  return (p, $) => {
    const l = f;
    return a(o) ? (c(), u(b, { key: 0, material: e.material }, { afterSpec: t(() => [n(l, { label: "厚 * 宽 * 长" }, { default: t(() => [i("span", null, r(`${e.material.thickness}${a(s).thickness.unit} * ${e.material.width}${a(s).width.unit} * ${e.material.length}${a(s).length.unit}`), 1)]), _: 1 })]), afterBrand: t(() => [n(l, { label: "炉批号/卷号" }, { default: t(() => [i("span", null, r(e.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"])) : d("", true);
  };
} };
export {
  C as default
};
