import { inject as h } from "vue";
import { computed as j } from "vue";
import { ref as M } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as i } from "vue";
import { createBlock as p } from "vue";
import { withCtx as t } from "vue";
import { createVNode as o } from "vue";
import { unref as n } from "vue";
import { createTextVNode as H } from "vue";
import { createElementVNode as E } from "vue";
import { toDisplayString as _ } from "vue";
import { createElementBlock as v } from "vue";
import { createCommentVNode as d } from "vue";
import { isRef as T } from "vue";
import { ElNotification as z } from "element-plus";
import { ElTableColumn as A } from "element-plus";
import { l as y, b_ as D, u as I, o as O, b as P } from "../../../../../shared/runtime.js";
import { _ as F } from "../../../../../modules/index-61ce89a1.js";
function L() {
  return y({ module: "wms", url: "config/material/high-tech-rd-fee", method: "get" });
}
function x(r) {
  return y({ module: "wms", url: "config/material/high-tech-rd-fee", method: "put", data: r });
}
const W = { get: L, save: x }, U = { key: 0 }, q = { key: 0 }, G = { __name: "config-preview", props: { visible: { type: Boolean, default: false }, data: { type: Array, default: () => [] }, level: { type: Number, default: 3 } }, emits: ["saveSuccess", "update:visible"], setup(r, { emit: N }) {
  const b = N, g = r, k = h("crud"), B = h("sourceMap"), c = j(() => g.data.filter((l) => D(l, B))), m = M(false), { visible: u, handleClose: w } = I({ emit: b, props: g, field: "visible" }), { maxHeight: V } = O({ mainBox: ".class-measure-preview", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true }, u);
  async function C() {
    try {
      m.value = true;
      const l = c.value.map((a) => ({ id: a.id, rdRate: a.rdRate }));
      await x(l), w(), k.refresh(), b("saveSuccess"), z({ title: "修改成功", type: "success" });
    } catch (l) {
      console.log("计量配置批量修改", l);
    } finally {
      m.value = false;
    }
  }
  return (l, a) => {
    const R = f("common-button"), s = A, S = f("common-table"), $ = f("common-dialog");
    return i(), p($, { "custom-class": "class-measure-preview", title: "变更详情", "append-to-body": "", modelValue: n(u), "onUpdate:modelValue": a[0] || (a[0] = (e) => T(u) ? u.value = e : null), width: "1200px", "before-close": n(w), top: "5vh" }, { titleRight: t(() => [o(R, { loading: m.value, disabled: n(P)(c.value), type: "primary", size: "default", onClick: C }, { default: t(() => a[1] || (a[1] = [H("保 存")])), _: 1, __: [1] }, 8, ["loading", "disabled"])]), default: t(() => [o(S, { data: c.value, "max-height": n(V), "empty-text": "未做改动", "row-key": "id" }, { default: t(() => [o(s, { label: "序号", type: "index", align: "center", width: "60" }), o(s, { "show-overflow-tooltip": true, prop: "first", label: "一级科目" }, { default: t((e) => [E("span", null, _(`${e.row.fullName[0]}-${e.row.fullSerialNumber[0]}`), 1)]), _: 1 }), r.level > 1 ? (i(), p(s, { key: 0, "show-overflow-tooltip": true, prop: "second", label: "二级科目" }, { default: t((e) => [e.row.fullName.length > 1 ? (i(), v("span", U, _(`${e.row.fullName[1]}-${e.row.fullSerialNumber[1]}`), 1)) : d("", true)]), _: 1 })) : d("", true), r.level > 2 ? (i(), p(s, { key: 1, "show-overflow-tooltip": true, prop: "third", label: "三级科目" }, { default: t((e) => [e.row.fullName.length > 2 ? (i(), v("span", q, _(`${e.row.fullName[2]}-${e.row.fullSerialNumber[2]}`), 1)) : d("", true)]), _: 1 })) : d("", true), o(s, { label: "研发费占比（%）", align: "center" }, { default: t((e) => [o(n(F), { old: e.row.sourceRdRate, new: e.row.rdRate }, null, 8, ["old", "new"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = Object.freeze(Object.defineProperty({ __proto__: null, default: G }, Symbol.toStringTag, { value: "Module" }));
export {
  G as _,
  X as a,
  W as c
};
