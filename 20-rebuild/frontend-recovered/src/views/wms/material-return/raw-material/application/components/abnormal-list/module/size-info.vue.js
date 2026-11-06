import { computed as h } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as _ } from "vue";
import { createBlock as m } from "vue";
import { withCtx as b } from "vue";
import { withDirectives as n } from "vue";
import { createElementVNode as i } from "vue";
import { unref as s } from "vue";
import { createCommentVNode as o } from "vue";
import { Fragment as x } from "vue";
import { createTextVNode as g } from "vue";
import { ElTableColumn as C } from "element-plus";
import { sQ as L, bl as p } from "../../../../../../../../shared/runtime.js";
const w = { class: "color-coral" }, y = { class: "color-coral" }, N = { __name: "size-info", props: { basicClass: { type: Number } }, setup(k) {
  const c = k, { baseUnit: t } = L(c.basicClass), v = h(() => [p.STEEL_PLATE.V, p.SECTION_STEEL.V].includes(c.basicClass)), f = h(() => p.STEEL_PLATE.V === c.basicClass), T = h(() => p.STEEL_PLATE.V === c.basicClass);
  return (V, r) => {
    const d = C, a = E("to-fixed"), u = E("empty-text");
    return l(), _(x, null, [T.value ? (l(), m(d, { key: 0, prop: "source.thickness", align: "center", width: "70px", label: `厚 (${s(t).thickness.unit})` }, { default: b(({ row: e }) => [n(i("span", null, null, 512), [[a, { val: e.thickness, dp: s(t).thickness.precision }]])]), _: 1 }, 8, ["label"])) : o("", true), f.value ? (l(), m(d, { key: 1, prop: "width", align: "center", width: "110px", label: `宽 (${s(t).width.unit})` }, { default: b(({ row: e }) => [n(i("span", null, null, 512), [[u], [a, { val: e.width, dp: s(t).width.precision }]]), e.maxWidth < e.width ? (l(), _(x, { key: 0 }, [r[0] || (r[0] = g(" -> ")), n(i("span", w, null, 512), [[u], [a, { val: e.maxWidth, dp: s(t).width.precision }]])], 64)) : o("", true)]), _: 1 }, 8, ["label"])) : o("", true), v.value ? (l(), m(d, { key: 2, prop: "length", align: "center", width: "110px", label: `长 (${s(t).length.unit})` }, { default: b(({ row: e }) => [n(i("span", null, null, 512), [[u], [a, { val: e.length, dp: s(t).length.precision }]]), e.maxLength < e.length ? (l(), _(x, { key: 0 }, [r[1] || (r[1] = g(" -> ")), n(i("span", y, null, 512), [[u], [a, { val: e.maxLength, dp: s(t).length.precision }]])], 64)) : o("", true)]), _: 1 }, 8, ["label"])) : o("", true)], 64);
  };
} };
export {
  N as default
};
