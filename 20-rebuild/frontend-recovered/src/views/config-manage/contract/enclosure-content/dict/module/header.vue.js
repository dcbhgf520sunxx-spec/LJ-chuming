import { resolveComponent as m } from "vue";
import { resolveDirective as E } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as O } from "vue";
import { withDirectives as p } from "vue";
import { vShow as R } from "vue";
import { unref as t } from "vue";
import { createElementVNode as D } from "vue";
import { createVNode as _ } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { createTextVNode as N } from "vue";
import { createCommentVNode as U } from "vue";
import { Fragment as B } from "vue";
import { ElPopconfirm as P } from "element-plus";
import { l as a, dn as n, B as k, E as w } from "../../../../../../shared/runtime.js";
function x(e) {
  return a({ module: "contract", url: "enclosure/dictionaries/dict", method: "get", params: e, cancelKey: false });
}
function F(e) {
  return a({ module: "contract", url: `enclosure/dictionaries/dictDetailSave/type/${n.TRUSS_FLOOR_PLATE.V}`, method: "post", data: e });
}
function I(e) {
  return a({ module: "contract", url: "enclosure/dictionaries/deleteCodes", method: "delete", data: e });
}
function z(e) {
  return a({ module: "contract", url: "enclosure/dictionaries/updateStatus/type/8", method: "put", params: e });
}
const H = { get: x, add: F }, L = { __name: "header", props: { selectArr: { type: Array, default: () => [] } }, emits: ["type-change"], setup(e, { emit: f }) {
  const g = { type: n.SANDWICH_BOARD.V }, { crud: r, query: s, CRUD: h } = k(g), S = f, d = e;
  function u() {
    r.toQuery(), S("type-change", {});
  }
  async function C() {
    const c = [];
    d.selectArr.map((o) => {
      c.push(o.code);
    });
    try {
      await I(c), r.notify("删除成功", h.NOTIFICATION_TYPE.SUCCESS), u();
    } catch (o) {
      console.log("删除失败", o);
    }
  }
  return (c, o) => {
    const T = m("common-radio-button"), b = m("common-button"), v = P, V = E("permission");
    return i(), O(B, null, [p(D("div", null, [_(T, { modelValue: t(s).type, "onUpdate:modelValue": o[0] || (o[0] = (A) => t(s).type = A), options: t(n).ENUM, type: "enum", "disabled-val": [t(n).STRUCTURE.V], class: "filter-item", onChange: u }, null, 8, ["modelValue", "options", "disabled-val"])], 512), [[R, t(r).searchToggle]]), t(s).type === t(n).TRUSS_FLOOR_PLATE.V ? (i(), y(t(w), { key: 0 }, { optRight: l(() => [_(v, { title: "确定删除吗？", onConfirm: C }, { reference: l(() => [p((i(), y(b, { type: "danger", size: "default", disabled: d.selectArr.length <= 0 }, { default: l(() => o[1] || (o[1] = [N("删除")])), _: 1, __: [1] }, 8, ["disabled"])), [[V, t(r).permission.del]])]), _: 1 })]), _: 1 })) : U("", true)], 64);
  };
} }, M = Object.freeze(Object.defineProperty({ __proto__: null, default: L }, Symbol.toStringTag, { value: "Module" }));
export {
  L as _,
  H as c,
  z as e,
  M as h
};
