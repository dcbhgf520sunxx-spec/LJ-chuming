import { ref as _ } from "vue";
import { reactive as M } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as B } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as m } from "vue";
import { unref as e } from "vue";
import { withDirectives as U } from "vue";
import { createBlock as r } from "vue";
import { withCtx as o } from "vue";
import { toDisplayString as s } from "vue";
import { createCommentVNode as u } from "vue";
import { createTextVNode as k } from "vue";
import { ElTableColumn as z } from "element-plus";
import { vLoading as E } from "element-plus";
import { c as O } from "../../../../modules/common-b3e76e54.js";
import { x as P, o as S, n8 as $, z as A, p as F, bn as p, G as L } from "../../../../shared/runtime.js";
import q from "./module/header.vue.js";
import G from "./module/handle-drawer.vue.js";
import I from "./module/detail-drawer.vue.js";
const K = { class: "app-container" }, J = { class: "head-container" }, W = { class: "project-name" }, le = { __name: "index", setup(X) {
  const y = { get: [""], edit: [""], add: [""], del: [""] }, Q = { add: false, edit: false, del: false, download: false }, v = _(), { crud: f, columns: d, CRUD: N } = P({ title: "零件变更", permission: { ...y }, optShow: { ...Q }, crudApi: { ...O }, hasPagination: false, dataPath: "" }, v), { maxHeight: C } = S({ paginate: false }), b = _(false), h = _(false);
  let w = M({});
  N.HOOK.handleRefresh = (c, l) => {
    l.data = l.data.map((a) => (a.changTypeText = $.VL[a.changeType], a.canHandleTotalMete = a.taskQuantity - (a.newQuantity + a.producedQuantity), a));
  };
  function D(c) {
    g(b, c);
  }
  function H(c) {
    g(h, c);
  }
  function g(c, l) {
    c.value = true, w = Object.assign(w, l);
  }
  return (c, l) => {
    const a = z, T = x("common-button"), R = x("common-table"), V = E;
    return n(), B("div", K, [i("div", J, [m(e(q))]), U((n(), r(R, { ref_key: "tableRef", ref: v, data: e(f).data, "empty-text": e(f).emptyText, "max-height": e(C), "row-key": "id", style: { width: "100%" } }, { default: o(() => [m(a, { label: "序号", type: "index", align: "center", width: "60" }), m(a, { prop: "project.shortName", label: "所属项目", "min-width": "250px" }, { default: o((t) => [i("span", W, s(e(A)(t.row.project)), 1)]), _: 1 }), e(d).visible("createTime") ? (n(), r(a, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "变更时间", width: "170", align: "center" }, { default: o((t) => [i("span", null, s(e(F)(t.row.createTime)), 1)]), _: 1 })) : u("", true), e(d).visible("userName") ? (n(), r(a, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "变更人" }, { default: o((t) => [i("span", null, s(e(p)(t.row.userName)), 1)]), _: 1 })) : u("", true), e(d).visible("serialNumber") ? (n(), r(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "零件编号" }, { default: o((t) => [i("span", null, s(e(p)(t.row.serialNumber)), 1)]), _: 1 })) : u("", true), e(d).visible("oldQuantity") ? (n(), r(a, { key: "oldQuantity", prop: "oldQuantity", "show-overflow-tooltip": true, label: "零件总数", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.oldQuantity)), 1)]), _: 1 })) : u("", true), e(d).visible("producedQuantity") ? (n(), r(a, { key: "producedQuantity", prop: "producedQuantity", "show-overflow-tooltip": true, label: "已生产量", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.producedQuantity)), 1)]), _: 1 })) : u("", true), e(d).visible("usedQuantity") ? (n(), r(a, { key: "usedQuantity", prop: "usedQuantity", "show-overflow-tooltip": true, label: "已使用量", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.usedQuantity)), 1)]), _: 1 })) : u("", true), e(d).visible("changTypeText") ? (n(), r(a, { key: "changTypeText", prop: "changTypeText", "show-overflow-tooltip": true, label: "变更类型", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.changTypeText)), 1)]), _: 1 })) : u("", true), e(d).visible("newQuantity") ? (n(), r(a, { key: "newQuantity", prop: "newQuantity", "show-overflow-tooltip": true, label: "还需零件数", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.newQuantity)), 1)]), _: 1 })) : u("", true), e(d).visible("canHandleTotalMete") ? (n(), r(a, { key: "canHandleTotalMete", prop: "canHandleTotalMete", "show-overflow-tooltip": true, label: "可修改任务数", align: "center" }, { default: o((t) => [i("span", null, s(e(p)(t.row.canHandleTotalMete)), 1)]), _: 1 })) : u("", true), e(L)([...y.edit, ...y.del]) ? (n(), r(a, { key: 9, label: "操作", width: "160px", align: "center", fixed: "right" }, { default: o((t) => [m(T, { size: "default", type: "primary", onClick: (j) => D(t.row) }, { default: o(() => l[2] || (l[2] = [k("处理")])), _: 2, __: [2] }, 1032, ["onClick"]), m(T, { size: "default", type: "info", onClick: (j) => H(t.row) }, { default: o(() => l[3] || (l[3] = [k("查看")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })) : u("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[V, e(f).loading]]), m(e(G), { visible: b.value, "onUpdate:visible": l[0] || (l[0] = (t) => b.value = t), info: e(w), onRefresh: e(f).toQuery }, null, 8, ["visible", "info", "onRefresh"]), m(e(I), { visible: h.value, "onUpdate:visible": l[1] || (l[1] = (t) => h.value = t), info: e(w) }, null, 8, ["visible", "info"])]);
  };
} };
export {
  le as default
};
