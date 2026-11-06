import { ref as m } from "vue";
import { inject as le } from "vue";
import { resolveComponent as D } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as y } from "vue";
import { createVNode as n } from "vue";
import { withCtx as o } from "vue";
import { unref as i } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as u } from "vue";
import { Fragment as E } from "vue";
import { renderList as ie } from "vue";
import { createCommentVNode as T } from "vue";
import { withModifiers as b } from "vue";
import { createTextVNode as x } from "vue";
import { createBlock as P } from "vue";
import { isRef as se } from "vue";
import { ElMessage as re } from "element-plus";
import { ElTableColumn as ce } from "element-plus";
import { InfoFilled as pe } from "@element-plus/icons-vue";
import { ElIcon as ue } from "element-plus";
import { ElTooltip as de } from "element-plus";
import { ElPopover as me } from "element-plus";
import { ElTag as fe } from "element-plus";
import { ElPagination as ye } from "element-plus";
import { g as he, m as _e, d as ge } from "./form.vue.js";
import { t as ve, o as be, u as ke, J as Ce, p as we, z as Ie, bV as De, c3 as V, iy as Ee } from "../../../../../shared/runtime.js";
import "../../../../../modules/UploadBtn-b4cfb47a.js";
const Te = { style: { display: "inline-block" } }, xe = ["onDblclick"], Ve = { style: { "text-align": "right", margin: "0" } }, Pe = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, query: { type: Object, default: () => {
} } }, emits: ["update:visible", "refresh"], setup(H, { emit: A }) {
  const { decimalPrecision: B } = ve(), F = A, j = m([]), h = m(false), S = m(), R = le("crud"), $ = m(false), _ = H, k = m(false), z = m({}), { maxHeight: L } = be({ extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }), { visible: C, handleClose: M } = ke({ emit: F, props: _, field: "visible", showHook: J }), { handleSizeChange: U, handleCurrentChange: q, total: O, setTotalPage: G, queryPage: w } = Ce({ fetchHook: g });
  function J() {
    g();
  }
  async function g() {
    var a, l, d;
    let t = [];
    try {
      const { content: f = [], totalElements: I } = await he({ year: (a = _.query) == null ? void 0 : a.year, testingFeeTypeId: (l = _.query) == null ? void 0 : l.testingFeeTypeId, projectId: (d = _.detailData.project) == null ? void 0 : d.id, ...w });
      G(I), t = f.map((r) => {
        var v;
        return r.pop = false, r.projectId = (v = r.project) == null ? void 0 : v.id, r;
      });
    } catch (f) {
      console.log("获取检测费用", f);
    } finally {
      j.value = t, console.log(t, "_list_list_list_list_list_list");
    }
  }
  function Q(t) {
    S.value = t.id, h.value = true;
  }
  async function Y(t) {
    try {
      const a = [];
      a.push(t.id), await ge(a), re({ type: "success", message: "删除成功" }), g(), F("refresh");
    } catch (a) {
      console.log("delClick", a);
    }
  }
  function K(t) {
    var l;
    const a = t.attachmentFiles ? t.attachmentFiles.map((d) => d.id) : t.attachmentIds;
    z.value = { payDate: t.payDate, projectId: (l = t.project) == null ? void 0 : l.id, testingFeeTypeId: t.testingFeeTypeId, branchCompanyId: t.branchCompanyId, attachmentIds: a, feeAmount: t.feeAmount, id: t.id, attachmentFiles: t.attachments, attachments: t.attachments, remark: t.remark }, k.value = true;
  }
  function W(t) {
    t.pop = true;
  }
  function X(t) {
    t.pop = false;
  }
  function N(t) {
    $.value = false;
  }
  function Z() {
    setTimeout(() => {
      document.addEventListener("click", N, { passive: false });
    }, 0);
  }
  function ee() {
    document.removeEventListener("click", N);
  }
  return (t, a) => {
    const l = ce, d = pe, f = ue, I = de, r = D("common-button"), v = me, te = fe, ae = D("common-table"), ne = ye, oe = D("common-drawer");
    return p(), y("div", null, [n(oe, { ref: "drawerRef", title: "检测费用详情", modelValue: i(C), "onUpdate:modelValue": a[0] || (a[0] = (e) => se(C) ? C.value = e : null), direction: "rtl", "before-close": i(M), size: "70%" }, { titleAfter: o(() => a[3] || (a[3] = [])), content: o(() => [n(ae, { ref: "tableRef", "show-empty-symbol": false, "max-height": i(L), data: j.value, style: { width: "100%" } }, { default: o(() => [n(l, { "show-overflow-tooltip": true, prop: "index", label: "序号", align: "center", width: "60", type: "index" }), n(l, { align: "center", key: "month", prop: "month", "show-overflow-tooltip": true, label: "月份", width: "80" }, { default: o(({ row: e }) => [s("span", null, u(e.month) + "月", 1)]), _: 1 }), n(l, { align: "center", key: "payDate", prop: "payDate", "show-overflow-tooltip": true, label: "支付日期", width: "120" }, { default: o((e) => [s("span", null, u(e.row.payDate ? i(we)(e.row.payDate, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), n(l, { prop: "branchCompanyName", label: "费用归属", align: "center" }, { default: o(({ row: e }) => [s("span", null, u(e.branchCompanyName || "-"), 1)]), _: 1 }), n(l, { align: "center", key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", "min-width": "150px" }, { default: o((e) => [s("span", null, u(i(Ie)(e.row.project)), 1)]), _: 1 }), n(l, { align: "center", key: "testingFeeTypeName", prop: "testingFeeTypeName", "show-overflow-tooltip": true, label: "检测费类别" }), n(l, { align: "center", key: "feeAmount", prop: "feeAmount", "show-overflow-tooltip": true, label: "费用" }, { default: o((e) => [s("span", null, u(i(De)(e.row.feeAmount, i(B).contract)), 1)]), _: 1 }), n(l, { align: "center", key: "attachments", prop: "attachments", "show-overflow-tooltip": true, label: "附件" }, { header: o(() => [n(I, { class: "item", effect: "dark", content: "双击编号可预览文附件", placement: "top" }, { default: o(() => [s("div", Te, [a[4] || (a[4] = s("span", null, "附件", -1)), n(f, null, { default: o(() => [n(d)]), _: 1 })])]), _: 1 })]), default: o((e) => [e.row.attachments && e.row.attachments.length > 0 ? (p(true), y(E, { key: 0 }, ie(e.row.attachments, (c) => (p(), y("div", { key: c.id }, [s("div", { style: { cursor: "pointer", color: "#409eff" }, onDblclick: (Fe) => Q(c) }, u(c.name), 41, xe)]))), 128)) : T("", true)]), _: 1 }), n(l, { align: "center", key: "remark", prop: "remark", "show-overflow-tooltip": true, label: "备注" }), n(l, { align: "center", label: "操作" }, { default: o(({ row: { sourceRow: e } }) => [e.auditStatusEnum === i(V).AUDITING.V ? (p(), y(E, { key: 0 }, [n(r, { type: "primary", size: "default", icon: "el-icon-edit", onClick: b((c) => K(e), ["stop"]) }, null, 8, ["onClick"]), n(v, { visible: e.pop, "onUpdate:visible": (c) => e.pop = c, placement: "top", width: "180", trigger: "manual", onShow: Z, onHide: ee }, { reference: o(() => [n(r, { type: "danger", icon: "el-icon-delete", size: "default", onClick: b((c) => W(e), ["stop"]) }, null, 8, ["onClick"])]), default: o(() => [a[7] || (a[7] = s("p", null, "确定删除吗？", -1)), s("div", Ve, [n(r, { size: "default", link: "", type: "primary", onClick: b((c) => X(e), ["stop"]) }, { default: o(() => a[5] || (a[5] = [x("取消")])), _: 2, __: [5] }, 1032, ["onClick"]), n(r, { type: "primary", size: "default", onClick: b((c) => Y(e), ["stop"]) }, { default: o(() => a[6] || (a[6] = [x("确定")])), _: 2, __: [6] }, 1032, ["onClick"])])]), _: 2, __: [7] }, 1032, ["visible", "onUpdate:visible"])], 64)) : (p(), y(E, { key: 1 }, [e.auditStatusEnum ? (p(), P(te, { key: 0, type: i(V).V[e.auditStatusEnum].TYPE }, { default: o(() => [x(u(i(V).VL[e.auditStatusEnum]), 1)]), _: 2 }, 1032, ["type"])) : T("", true)], 64))]), _: 1 })]), _: 1 }, 8, ["max-height", "data"]), n(ne, { total: i(O), "current-page": i(w).pageNumber, "page-size": i(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(U), onCurrentChange: i(q) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), n(_e, { visible: k.value, "onUpdate:visible": a[1] || (a[1] = (e) => k.value = e), info: z.value, onSuccess: g, onRefresh: i(R).toQuery }, null, 8, ["visible", "info", "onRefresh"]), h.value ? (p(), P(Ee, { key: 0, isVisible: h.value, showType: "attachment", id: S.value, onClose: a[2] || (a[2] = (e) => h.value = false) }, null, 8, ["isVisible", "id"])) : T("", true)]);
  };
} };
export {
  Pe as default
};
