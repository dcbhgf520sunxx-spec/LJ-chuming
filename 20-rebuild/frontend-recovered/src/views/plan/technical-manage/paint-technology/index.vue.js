import { ref as d } from "vue";
import { computed as k } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as l } from "vue";
import { unref as o } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as y } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as b } from "vue";
import { createTextVNode as I } from "vue";
import { createCommentVNode as v } from "vue";
import { ElMessageBox as z } from "element-plus";
import { ElMessage as G } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElTag as J } from "element-plus";
import { vLoading as W } from "element-plus";
import { a as E, c as X } from "./components/create-form.vue.js";
import { _ as Y, x as Z, o as j, i as ee, tM as N, p as te, G as V, P as ae } from "../../../../shared/runtime.js";
import ne from "./module/header.vue.js";
import oe from "./components/select-drawer.vue.js";
import { F as x } from "../../../../modules/plan-d12d7ccf.js";
import "../../../../modules/project-select-94bb5bbd.js";
import "./components/select-all-dialog.vue.js";
const le = { class: "app-container" }, re = { class: "head-container" }, ie = { __name: "index", setup(se) {
  const D = { add: false, edit: false, del: false }, T = d(), h = d(false), p = d(false), S = d([]), B = d(void 0), g = d(null), { crud: r, CRUD: R } = Z({ title: "涂装工艺", sort: ["id.desc"], permission: { ...x }, optShow: { ...D }, crudApi: { ...E }, hasPagination: true }, T), { maxHeight: M } = j({ wrapperBox: ".paint-technology", paginate: true, extraHeight: 40 }), Q = k(() => {
    const a = [];
    let e = 0;
    return (r.data || []).forEach((t) => {
      var i;
      const s = Math.max(((i = t == null ? void 0 : t.paintTechnologyList) == null ? void 0 : i.length) || 1, 1);
      a.push({ start: e, rowspan: s }), e += s;
    }), a;
  }), U = k(() => {
    const a = [];
    return (r.data || []).forEach((e, t) => {
      var f;
      const s = (e == null ? void 0 : e.paintTechnologyList) || [], i = ((f = e == null ? void 0 : e.project) == null ? void 0 : f.name) || "-", m = (e == null ? void 0 : e.totalQuantity) || 0;
      if (!s.length) {
        a.push({ projectId: e == null ? void 0 : e.projectId, projectName: i, totalQuantity: m, displayOrder: `${t + 1}.1`, serialNumber: "-", quantity: 0, createUserName: "-", createTime: null, isReferenced: true });
        return;
      }
      s.forEach((n, _) => {
        a.push({ ...n, projectId: e == null ? void 0 : e.projectId, project: e == null ? void 0 : e.project, projectName: i, totalQuantity: m, displayOrder: `${t + 1}.${_ + 1}` });
      });
    }), a;
  });
  function q(a) {
    const e = Q.value.find((t) => a >= t.start && a < t.start + t.rowspan);
    return e ? a === e.start ? e.rowspan : 0 : 1;
  }
  function L({ columnIndex: a, rowIndex: e }) {
    if (a === 1 || a === 2) {
      const t = q(e);
      return { rowspan: t, colspan: t > 0 ? 1 : 0 };
    }
    return { rowspan: 1, colspan: 1 };
  }
  function O(a) {
    g.value = { ...a, paintTechnologyDetailList: a.paintTechnologyDetailList || [] }, p.value = true;
  }
  async function P(a) {
    try {
      await z.confirm("确定删除该工艺吗？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await E.delete(a.id), G.success("删除成功"), r.toQuery();
    } catch (e) {
      e !== "cancel" && console.log("删除失败", e);
    }
  }
  function $(a, e) {
    (!a || a.length === 0) && r.toQuery();
  }
  function F() {
    p.value = false, S.value = [], B.value = void 0, g.value = null, r.toQuery();
  }
  return R.HOOK.beforeToAdd = () => (h.value = true, false), (a, e) => {
    const t = K, s = J, i = C("common-button"), m = C("common-table"), f = W;
    return c(), A("div", le, [w("div", re, [l(o(ne))]), H((c(), y(m, { ref_key: "tableRef", ref: T, data: U.value, "empty-text": o(r).emptyText, "max-height": o(M), "return-source-data": "", style: { width: "100%" }, "span-method": L, onSortChange: o(r).handleSortChange }, { default: u(() => [l(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), l(t, { key: "project", prop: "projectName", "show-overflow-tooltip": true, label: "项目", "min-width": "150px" }, { default: u((n) => [w("span", null, b(n.row.projectName || "-"), 1)]), _: 1 }), l(t, { key: "totalQuantity", prop: "totalQuantity", label: "清单数量（件）", align: "center", "min-width": "120px" }), l(t, { key: "listOrder", prop: "displayOrder", "show-overflow-tooltip": true, label: "单号", "min-width": "120px" }), l(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "工艺编号", "min-width": "120px" }), l(t, { key: "rangeTypeEnum", prop: "rangeTypeEnum", "show-overflow-tooltip": true, label: "选择范围", "min-width": "120px" }, { default: u((n) => [o(ee)(n.row.rangeTypeEnum) ? (c(), y(s, { key: 0, type: o(N).V[n.row.rangeTypeEnum].T }, { default: u(() => [I(b(o(N).V[n.row.rangeTypeEnum].L), 1)]), _: 2 }, 1032, ["type"])) : v("", true)]), _: 1 }), l(t, { key: "quantity", prop: "quantity", label: "已创建工艺（件）", align: "center", "min-width": "140px" }), l(t, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, label: "创建人", "min-width": "100px" }), l(t, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "日期", "min-width": "120px" }, { default: u((n) => [w("span", null, b(n.row.createTime ? o(te)(n.row.createTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), l(t, { key: "operation", label: "操作", align: "center", width: "180px", fixed: "right" }, { default: u((n) => [o(V)(o(x).edit) ? (c(), y(i, { key: 0, disabled: n.row.isReferenced, type: "primary", size: "default", icon: "el-icon-edit", onClick: (_) => O(n.row) }, null, 8, ["disabled", "onClick"])) : v("", true), o(V)(o(x).del) ? (c(), y(i, { key: 1, disabled: n.row.isReferenced, type: "danger", size: "default", icon: "el-icon-delete", onClick: (_) => P(n.row) }, null, 8, ["disabled", "onClick"])) : v("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[f, o(r).loading]]), l(o(ae)), l(oe, { modelValue: h.value, "onUpdate:modelValue": e[0] || (e[0] = (n) => h.value = n), "project-id": o(r).query.projectId, onConfirm: $ }, null, 8, ["modelValue", "project-id"]), l(X, { modelValue: p.value, "onUpdate:modelValue": e[1] || (e[1] = (n) => p.value = n), "form-data": g.value, "artifact-list": [], "range-type": void 0, "project-id": o(r).query.projectId, onSuccess: F }, null, 8, ["modelValue", "form-data", "project-id"])]);
  };
} }, we = Y(ie, [["__scopeId", "data-v-2bcebffe"]]);
export {
  we as default
};
