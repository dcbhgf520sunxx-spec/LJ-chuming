import { unref as t } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as e } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as n } from "vue";
import { createCommentVNode as d } from "vue";
import { ElFormItem as f } from "element-plus";
import { sQ as p } from "../../../../../../../shared/runtime.js";
import b from "../components/common-material-info.vue.js";
const C = { __name: "steel-coil", props: { basicClass: { type: Number }, material: { type: Object } }, setup(a) {
  const o = a, { loaded: c, baseUnit: s } = p(o.basicClass);
  return (h, _) => {
    const r = f;
    return t(c) ? (m(), u(b, { key: 0, material: a.material }, { afterSpec: e(() => [i(r, { label: "厚 * 宽" }, { default: e(() => [l("span", null, n(`${a.material.thickness}${t(s).thickness.unit} * ${a.material.width}${t(s).width.unit}`), 1)]), _: 1 })]), afterBrand: e(() => [i(r, { label: "炉批号/卷号" }, { default: e(() => [l("span", null, n(a.material.heatNoAndBatchNo), 1)]), _: 1 })]), _: 1 }, 8, ["material"])) : d("", true);
  };
} };
export {
  C as default
};
