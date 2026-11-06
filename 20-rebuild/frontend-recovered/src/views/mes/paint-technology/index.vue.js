import { ref as i } from "vue";
import { computed as N } from "vue";
import { provide as C } from "vue";
import { resolveComponent as E } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as g } from "vue";
import { createElementVNode as S } from "vue";
import { createVNode as o } from "vue";
import { withDirectives as J } from "vue";
import { unref as p } from "vue";
import { createBlock as y } from "vue";
import { withCtx as l } from "vue";
import { toDisplayString as L } from "vue";
import { createTextVNode as T } from "vue";
import { ElMessage as K } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { ElTag as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { c as j, l as tt } from "./components/list-detail-dialog.vue.js";
import { _ as et, x as at, op as M, o as nt, p as ot, P as it, G as lt, or as st, os as rt, ot as pt } from "../../../shared/runtime.js";
import ut from "./module/header.vue.js";
import ct from "./paint-config/index.vue.js";
import dt from "./components/paint-calc-dialog.vue.js";
import "../../../modules/paint-config-780a81bc.js";
import "./paint-config/module/form.vue.js";
import "./paint-config/module/header.vue.js";
import "../../../modules/ExcelUploadBtn-acccae97.js";
import "./components/statistics-report.vue.js";
const mt = { class: "app-container paint-technology" }, ft = { class: "head-container" }, gt = ["onClick"], yt = { key: 1 }, ht = { key: 3 }, wt = { __name: "index", setup(_t) {
  const Q = { add: false, edit: false, del: false }, P = i(), d = i(false), h = i(false), m = i(null), U = i(void 0), w = i(false), _ = i([]), v = i([]), b = i([]), { crud: u } = at({ title: "涂装工艺", sort: [], permission: { ...M }, optShow: { ...Q }, crudApi: { ...j }, hasPagination: true }, P), { maxHeight: q } = nt({ wrapperBox: ".paint-technology", paginate: true, extraHeight: 40 }), $ = N(() => {
    const e = [];
    let t = 0;
    return (u.data || []).forEach((a) => {
      var c;
      const s = Math.max(((c = a == null ? void 0 : a.paintTechnologyList) == null ? void 0 : c.length) || 1, 1);
      e.push({ start: t, rowspan: s }), t += s;
    }), e;
  }), z = N(() => {
    const e = [];
    return (u.data || []).forEach((t, a) => {
      var f;
      const s = (t == null ? void 0 : t.paintTechnologyList) || [], c = ((f = t == null ? void 0 : t.project) == null ? void 0 : f.name) || "-", x = (t == null ? void 0 : t.totalQuantity) || 0;
      s.forEach((n, k) => {
        e.push({ ...n, projectId: t == null ? void 0 : t.projectId, project: t == null ? void 0 : t.project, projectName: c, totalQuantity: x, displayOrder: `${a + 1}.${k + 1}` });
      });
    }), e;
  });
  function H(e) {
    const t = $.value.find((a) => e >= a.start && e < a.start + a.rowspan);
    return t ? e === t.start ? t.rowspan : 0 : 1;
  }
  function O({ columnIndex: e, rowIndex: t }) {
    if (e === 1 || e === 2) {
      const a = H(t);
      return { rowspan: a, colspan: a > 0 ? 1 : 0 };
    }
    return { rowspan: 1, colspan: 1 };
  }
  function R(e) {
    m.value = e, d.value = true;
  }
  function F(e) {
    if (!lt(M.listDetail)) {
      K({ message: "您没有查看清单明细的权限", type: "warning" });
      return;
    }
    m.value = e, h.value = true;
  }
  function A(e) {
    U.value = e;
  }
  function W() {
    d.value = false, u.toQuery();
  }
  function G() {
    w.value = true;
  }
  async function V() {
    try {
      const { content: e } = await st();
      _.value = e || [];
    } catch (e) {
      console.log(e);
    }
  }
  async function B() {
    try {
      const { content: e } = await rt();
      v.value = e || [];
    } catch (e) {
      console.log(e);
    }
  }
  async function D() {
    try {
      const { content: e } = await pt();
      b.value = e || [];
    } catch (e) {
      console.log(e);
    }
  }
  V(), B(), D();
  function I() {
    console.log(111), V(), B(), D();
  }
  return C("paintBrandList", _), C("paintTypeList", v), C("paintselectList", b), (e, t) => {
    const a = X, s = Y, c = E("common-button"), x = E("common-table"), f = Z;
    return r(), g("div", mt, [S("div", ft, [o(ut, { onFilterChange: A, onOpenPaintConfig: G })]), J((r(), y(x, { ref_key: "tableRef", ref: P, data: z.value, "empty-text": p(u).emptyText, "max-height": p(q), "return-source-data": "", style: { width: "100%" }, "span-method": O, onSortChange: p(u).handleSortChange }, { default: l(() => [o(a, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), o(a, { key: "project", prop: "projectName", "show-overflow-tooltip": true, label: "项目", "min-width": "150px" }, { default: l((n) => [S("span", null, L(n.row.projectName || "-"), 1)]), _: 1 }), o(a, { key: "totalQuantity", prop: "totalQuantity", label: "清单数量（件）", align: "center", "min-width": "120px" }), o(a, { key: "listOrder", prop: "displayOrder", "show-overflow-tooltip": true, label: "单号", "min-width": "120px" }), o(a, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "工艺编号", "min-width": "120px" }), o(a, { key: "quantity", prop: "quantity", label: "数量（件）", align: "center", "min-width": "100px" }, { default: l((n) => [n.row.quantity ? (r(), g("span", { key: 0, class: "clickable-text", onClick: (k) => F(n.row) }, L(n.row.quantity), 9, gt)) : (r(), g("span", yt, "-"))]), _: 1 }), o(a, { key: "createUserName", prop: "createUserName", "show-overflow-tooltip": true, label: "创建人", "min-width": "100px" }), o(a, { key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "日期", "min-width": "120px" }, { default: l((n) => [S("span", null, L(n.row.createTime ? p(ot)(n.row.createTime, "{y}-{m}-{d} {h}:{i}") : "-"), 1)]), _: 1 }), o(a, { key: "paintCalculateStatus", prop: "paintCalculateStatus", label: "状态", align: "center", "min-width": "100px" }, { default: l((n) => [n.row.paintCalculateStatus === 1 ? (r(), y(s, { key: 0, type: "danger", size: "small" }, { default: l(() => t[3] || (t[3] = [T("未计算")])), _: 1, __: [3] })) : n.row.paintCalculateStatus === 2 ? (r(), y(s, { key: 1, type: "warning", size: "small" }, { default: l(() => t[4] || (t[4] = [T("部分计算")])), _: 1, __: [4] })) : n.row.paintCalculateStatus === 4 ? (r(), y(s, { key: 2, type: "success", size: "small" }, { default: l(() => t[5] || (t[5] = [T("全部计算")])), _: 1, __: [5] })) : (r(), g("span", ht, "-"))]), _: 1 }), o(a, { key: "paintWeight", prop: "paintWeight", label: "油漆用量(kg)", align: "center", "min-width": "100px" }), o(a, { key: "operation", label: "操作", align: "center", width: "120px", fixed: "right" }, { default: l((n) => [o(c, { type: "primary", size: "default", icon: "el-icon-view", onClick: (k) => R(n.row) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "onSortChange"])), [[f, p(u).loading]]), o(p(it)), o(dt, { modelValue: d.value, "onUpdate:modelValue": t[0] || (t[0] = (n) => d.value = n), "row-data": m.value, onSuccess: W }, null, 8, ["modelValue", "row-data"]), o(tt, { modelValue: h.value, "onUpdate:modelValue": t[1] || (t[1] = (n) => h.value = n), "row-data": m.value }, null, 8, ["modelValue", "row-data"]), o(p(ct), { visible: w.value, "onUpdate:visible": t[2] || (t[2] = (n) => w.value = n), paintBrandList: _.value, paintTypeList: v.value, paintSelectList: b.value, onConfigSuccess: I }, null, 8, ["visible", "paintBrandList", "paintTypeList", "paintSelectList"])]);
  };
} }, Et = et(wt, [["__scopeId", "data-v-cbf10ae1"]]);
export {
  Et as default
};
