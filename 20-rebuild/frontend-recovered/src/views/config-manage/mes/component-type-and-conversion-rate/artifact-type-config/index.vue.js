import { ref as V } from "vue";
import { inject as z } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as l } from "vue";
import { createBlock as c } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as b } from "vue";
import { unref as e } from "vue";
import { createTextVNode as _ } from "vue";
import { createCommentVNode as f } from "vue";
import { withDirectives as H } from "vue";
import { createVNode as r } from "vue";
import { toDisplayString as y } from "vue";
import { ElMessageBox as P } from "element-plus";
import { ElNotification as R } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElCard as M } from "element-plus";
import { vLoading as S } from "element-plus";
import { l as u, x as q, o as G, G as g } from "../../../../../shared/runtime.js";
import L from "./module/form.vue.js";
import U from "./module/editForm.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
function F(t) {
  return u({ url: "/api/mes/building/mes_artifact_class/listAll", method: "get", params: t });
}
function I(t) {
  return u({ url: "/api/mes/building/mes_artifact_class/save", method: "post", data: t });
}
function J(t) {
  return u({ url: "/api/mes/building/mes_artifact_class/update", method: "put", data: t });
}
function K(t) {
  return u({ url: "/api/mes/building/mes_artifact_class/delete", method: "delete", data: t });
}
const C = { get: F, batchAdd: I, edit: J, del: K }, O = { class: "clearfix" }, ee = { __name: "index", emits: ["currentChange"], setup(t, { emit: k }) {
  const h = V(), m = z("permission"), w = k, { crud: i } = q({ title: "构件类别", permission: { ...m }, crudApi: { ...C }, hasPagination: false, dataPath: "" }, h), { maxHeight: v } = G({ extraBox: [".el-card__header"], paginate: false, extraHeight: 50 });
  function B(s) {
    P.confirm(`是否确认删除【${s.name}】？`, { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      await C.del([s.id]), R({ title: "删除成功", type: "success", duration: 2500 }), i.refresh();
    }).catch((a) => {
      console.log(a, "删除失败");
    });
  }
  function $(s) {
    w("currentChange", s);
  }
  return (s, a) => {
    const A = p("common-tip-button"), d = j, x = p("common-button"), D = p("common-table"), E = M, N = S;
    return l(), c(E, null, { header: o(() => [b("div", O, [a[2] || (a[2] = b("span", { class: "card-title" }, "构件类别", -1)), e(g)(e(m).add) ? (l(), c(A, { key: 0, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: a[0] || (a[0] = (n) => e(i).toBatchAdd()) }, { default: o(() => a[1] || (a[1] = [_(" 新增 ")])), _: 1, __: [1] })) : f("", true)])]), default: o(() => [H((l(), c(D, { ref_key: "tableRef", ref: h, data: e(i).data, "empty-text": e(i).emptyText, "max-height": e(v), "highlight-current-row": "", onCurrentChange: $, style: { width: "100%" } }, { default: o(() => [r(d, { label: "序号", type: "index", align: "center", width: "60" }), r(d, { key: "name", prop: "name", "show-overflow-tooltip": "", align: "center", label: "构件类别名称" }, { default: o((n) => [_(y(n.row.name || "-"), 1)]), _: 1 }), r(d, { key: "remark", prop: "remark", "show-overflow-tooltip": "", align: "center", label: "备注" }, { default: o((n) => [_(y(n.row.remark || "-"), 1)]), _: 1 }), r(d, { label: "操作", align: "center", fixed: "right" }, { default: o((n) => [e(g)(e(m).edit) ? (l(), c(x, { key: 0, type: "primary", size: "default", icon: "el-icon-edit", onClick: (T) => e(i).toEdit(n.row) }, null, 8, ["onClick"])) : f("", true), e(g)(e(m).del) ? (l(), c(x, { key: 1, type: "danger", size: "default", icon: "el-icon-delete", onClick: (T) => B(n.row) }, null, 8, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[N, e(i).loading]]), r(e(L)), r(e(U))]), _: 1 });
  };
} };
export {
  ee as default
};
