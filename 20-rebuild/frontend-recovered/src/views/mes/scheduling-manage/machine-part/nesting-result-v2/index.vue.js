import { ref as m } from "vue";
import { computed as z } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as s } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as v } from "vue";
import { createVNode as d } from "vue";
import { unref as t } from "vue";
import { normalizeStyle as Pe } from "vue";
import { withDirectives as B } from "vue";
import { vShow as ie } from "vue";
import { withCtx as o } from "vue";
import { createTextVNode as h } from "vue";
import { createBlock as r } from "vue";
import { createCommentVNode as u } from "vue";
import { toDisplayString as _ } from "vue";
import { Fragment as je } from "vue";
import { ElMessage as O } from "element-plus";
import { ElDivider as Ue } from "element-plus";
import { ElTag as ze } from "element-plus";
import { ElTableColumn as Me } from "element-plus";
import { ElFormItem as He } from "element-plus";
import { ElDatePicker as we } from "element-plus";
import { ElForm as Fe } from "element-plus";
import { vLoading as Be } from "element-plus";
import { nextTick as ne } from "vue";
import { ElNotification as Oe } from "element-plus";
import { ElMessageBox as Qe } from "element-plus";
import { _ as Je, x as Ge, ra as N, rb as $e, o as se, rc as Q, qz as b, rd as Ye, G as A, L as We, re as Ke, p as oe, i as Xe, rf as ue, rg as Ze, rh as et, qR as tt, oT as at, qw as lt, cf as it, ri as nt, rj as st, rk as ot, rl as ut, rm as dt } from "../../../../../shared/runtime.js";
import rt from "./module/nesting-document-dialog.vue.js";
import ct from "./module/drill-scheduling-dialog.vue.js";
import mt from "./module/nesting-task-list.vue.js";
import pt from "./module/header.vue.js";
import "../../../../../modules/print-e379c493.js";
import "./module/nesting-detail.vue.js";
const ft = { class: "app-container wrap" }, gt = { class: "wrap-left" }, yt = { class: "wrap-right" }, vt = { class: "head-container wrap-right-head" }, ht = { key: 0 }, _t = { style: { "font-size": "12px" } }, bt = { key: 1 }, St = { key: 0 }, kt = { style: { "font-size": "12px" } }, It = { key: 1 }, Tt = { key: 0 }, Dt = { key: 1 }, xt = { key: 1 }, Ct = { class: "dialog-operate" }, Nt = { __name: "index", setup(Et) {
  const E = m(), L = m(), J = m(), x = m({}), de = m(), G = m(), M = m(false), $ = m(), I = m(), T = m(false), D = m(false), P = m(false), H = m({}), j = m(), w = m(), { crud: a, columns: f, CRUD: re } = Ge({ title: "套料成果", sort: [], permission: { ...N }, crudApi: { get: $e }, invisibleColumns: [""], hasPagination: false, requiredQuery: ["jobId"], queryOnPresenterCreated: false }, J), { maxHeight: ce } = se({ extraBox: [".wrap-right-head"], paginate: false }), { maxHeight: me } = se({ extraBox: "", paginate: false }), pe = z(() => I.value === "produce" ? "任务下发" : "任务删除"), fe = z(() => a.selections.reduce((i, e) => i + e.amount, 0)), g = m(JSON.parse(JSON.stringify({ machineToolId: void 0, finishDate: void 0 }))), q = m({ deleteScope: Q.DELETE_NESTING_AND_PART.V }), F = z(() => a.query.cutSendStatus === b.HAS_ISSUED.V && a.selections.some((i) => i.cutStatus === Ye.CUT.V)), ge = { machineToolId: [{ required: true, message: "请选择机床", trigger: "change" }], finishDate: [{ required: true, message: "请选择完成日期", trigger: "change" }] }, ye = { deleteScope: [{ required: true, message: "请选择删除范围", trigger: "change" }] }, ve = z(() => {
    var i, e;
    return { data: (i = a.selections) == null ? void 0 : i.map((n) => {
      var p;
      return { id: n.id, guid: n.guid, thick: n.thickness, width: n.plateWidth, length: n.plateHeight, quantity: n.amount, machineToolId: (p = g.value) == null ? void 0 : p.machineToolId, partQuantity: n.partAmount, material: n.material, childGuid: n.childGuid };
    }), finishDate: (e = j.value) == null ? void 0 : e.artifactAskCompleteTime };
  });
  function he() {
    E.value && (E.value.resetFields(), ne(() => {
      E.value.clearValidate();
    })), L.value && (L.value.resetFields(), ne(() => {
      q.value.deleteScope = Q.DELETE_NESTING_AND_PART.V;
    }));
  }
  function _e() {
    he();
  }
  const be = async (i) => {
    try {
      const e = await tt({ partProdMode: at.NUMERICAL_CONTROL.V, partType: lt.BOARD.V, processType: it.MAKINGS.V });
      de.value = e, G.value = e.map((n) => ({ name: n.deviceName, id: n.id }));
    } catch (e) {
      console.log(e);
    }
  };
  async function Se({ node: i, cutSendStatus: e }) {
    var n, p;
    if (a.query.jobId = ((n = i[0]) == null ? void 0 : n.jobId) || void 0, a.query.cutSendStatus = e, x.value = i[0] || {}, a.query.jobId) {
      a.toQuery(), be(Number((p = i[0]) == null ? void 0 : p.workshopId));
      const y = await Ze({ jobId: a.query.jobId });
      x.value.amount = y.totalQuantity, x.value.nestingQuantity = y.nestedTotalQuantity, x.value.cutQuantity = y.reportedTotalQuantity;
    }
  }
  re.HOOK.handleRefresh = (i, e) => {
    e.data.content = e.data.map((n, p) => (n.orderIndex = p + 1, n));
  };
  const ke = (i) => {
    M.value = true, $.value = i;
  };
  async function Ie() {
    var i;
    try {
      const e = await nt({ jobId: a.query.jobId });
      j.value = (e == null ? void 0 : e[0]) || [], g.value.finishDate = (i = j.value) == null ? void 0 : i.artifactAskCompleteTime;
    } catch (e) {
      console.log(e);
    }
  }
  function Te() {
    const [i] = a.selections, e = a.selections.every((p) => p.machineToolId === i.machineToolId && a.query.cutSendStatus === b.HAS_ISSUED.V), n = a.query.cutSendStatus === b.NOT_ISSUED.V;
    e || n ? (I.value = "produce", T.value = true) : O({ type: "error", message: "相同的机床才能一起排产" }), Ie();
  }
  function De() {
    I.value = "delete", T.value = true;
  }
  async function xe() {
    var i, e;
    try {
      w.value = true, await et({ jobId: ((i = a.query) == null ? void 0 : i.jobId) || void 0, nestingResultIdList: ((e = a.selections) == null ? void 0 : e.map((n) => n.id)) || [] }), a.toQuery(), O.success("撤回成功！");
    } catch (n) {
      console.log(n);
    } finally {
      w.value = false;
    }
  }
  function Ce() {
    const e = { delete: Ee, produce: qe }[I.value];
    e && e();
  }
  function Ne() {
    T.value = false, a.toQuery();
  }
  async function Ee() {
    var i;
    D.value = true;
    try {
      if (!await L.value.validate()) return false;
      await st({ jobId: a.query.jobId, deleteScope: q.value.deleteScope || void 0, nestingResultIdList: (i = a.selections) == null ? void 0 : i.map((n) => n.id) }), a.toQuery(), T.value = false, O.success("删除成功！");
    } catch (e) {
      console.log(e);
    } finally {
      D.value = false;
    }
  }
  async function qe() {
    var i, e;
    D.value = true;
    try {
      if (!await E.value.validate()) return false;
      const p = [...new Set(a.selections.map((C) => C.thickness))], y = a.selections.map((C) => C.partList).filter(Boolean).flat(), c = await ot({ thickList: p, cutConfigId: g.value.machineToolId || void 0, partList: y });
      if (c.boolDrillEnum) c.boolAllMatched ? (P.value = true, H.value = c || {}) : Qe.confirm("所选厚度未能完全匹配，请确认钻孔配置！", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning", draggable: true }).then(() => {
        P.value = true, H.value = c || {};
      }).catch(() => {
      });
      else {
        const C = a.selections.map((S) => (S.thick = S.thickness, S));
        a.query.cutSendStatus === b.HAS_ISSUED.V ? await ut({ finishDate: g.value.finishDate, jobId: (i = a == null ? void 0 : a.query) == null ? void 0 : i.jobId, machinePartCuttingConfigId: g.value.machineToolId, nestingResultIdList: a.selections.map((S) => S.id) }) : await dt({ finishDate: g.value.finishDate, jobId: (e = a == null ? void 0 : a.query) == null ? void 0 : e.jobId, machinePartCuttingConfigId: g.value.machineToolId, nestingResultIdList: a.selections.map((S) => S.id) }), Oe({ title: "下发成功", type: "success", duration: 2e3 }), T.value = false, a.toQuery();
      }
    } catch (n) {
      console.error(n);
    } finally {
      D.value = false;
    }
  }
  function Ve(i) {
    var e;
    return i > ((e = j.value) == null ? void 0 : e.artifactAskCompleteTime);
  }
  return (i, e) => {
    var K, X, Z, ee, te, ae, le;
    const n = Ue, p = ze, y = R("common-button"), c = Me, C = R("table-cell-tag"), S = R("common-table"), U = He, Y = R("common-select"), Re = we, W = Fe, Ae = R("common-dialog"), Le = Be;
    return s(), k("div", ft, [v("div", gt, [d(t(mt), { ref: "nestingTaskRef", onNestingTaskClick: Se }, null, 512)]), d(n, { direction: "vertical", style: Pe(`height: ${t(me)}px`) }, null, 8, ["style"]), v("div", yt, [B(d(p, { type: "info", size: "large" }, { default: o(() => e[6] || (e[6] = [h(" * 请先选择套料任务，进行零件任务下发 ")])), _: 1, __: [6] }, 512), [[ie, !((X = (K = t(a)) == null ? void 0 : K.query) != null && X.jobId)]]), B(v("div", null, [v("div", vt, [d(t(pt), { labelInfo: x.value }, { right: o(() => {
      var l;
      return [v("span", null, [t(a).query.cutSendStatus === t(b).HAS_ISSUED.V && t(A)(t(N).revocation) ? (s(), r(t(We), { key: 0, params: { jobId: t(a).query.jobId, nestingResultIdList: (l = t(a).selections) == null ? void 0 : l.map((V) => V.id) }, fn: t(Ke), disabled: !t(a).selections.length, "response-header-result": "", boolElLoading: "", type: "warning", size: "default", loadingText: "正在下载报告单，请稍后", style: { "margin-right": "10px" } }, { default: o(() => e[7] || (e[7] = [h(" 批量下载报告单 ")])), _: 1, __: [7] }, 8, ["params", "fn", "disabled"])) : u("", true), t(a).query.cutSendStatus === t(b).NOT_ISSUED.V && t(A)(t(N).del) ? (s(), r(y, { key: 1, class: "filter-item", size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-bottom": "0" }, disabled: !t(a).selections.length || F.value, onClick: De }, { default: o(() => e[8] || (e[8] = [h(" 删除任务 ")])), _: 1, __: [8] }, 8, ["disabled"])) : u("", true), t(a).query.cutSendStatus === t(b).HAS_ISSUED.V && t(A)(t(N).revocation) ? (s(), r(y, { key: 2, class: "filter-item", size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-bottom": "0" }, disabled: !t(a).selections.length || F.value, loading: w.value, onClick: xe }, { default: o(() => e[9] || (e[9] = [h(" 撤回任务 ")])), _: 1, __: [9] }, 8, ["disabled", "loading"])) : u("", true), t(A)(t(N).scheduling) ? (s(), r(y, { key: 3, class: "filter-item", size: "default", type: "success", icon: "el-icon-document", style: { "margin-bottom": "0" }, disabled: !t(a).selections.length || F.value, onClick: Te }, { default: o(() => e[10] || (e[10] = [h(" 排产 ")])), _: 1, __: [10] }, 8, ["disabled"])) : u("", true)])];
    }), _: 1 }, 8, ["labelInfo"])]), B((s(), r(S, { ref_key: "tableRef", ref: J, data: (Z = t(a)) == null ? void 0 : Z.data, "empty-text": (ee = t(a)) == null ? void 0 : ee.emptyText, "max-height": t(ce), "cell-class-name": i.wrongCellMask, style: { width: "100%" }, id: "listTabless", onSelectionChange: t(a).selectionChangeHandler }, { default: o(() => [d(c, { type: "selection", width: "50", align: "center", selectable: i.selectable, fixed: "left" }, null, 8, ["selectable"]), d(c, { label: "序号", type: "index", align: "center", fixed: "left" }), t(f).visible("thickness") ? (s(), r(c, { key: 0, prop: "thickness", label: "厚度（mm）", align: "center", "min-width": "95" }, { default: o(({ row: l }) => [l != null && l.isMixNest ? (s(), r(C, { key: 0, name: "混套", color: "#67C23A", offset: 10 })) : u("", true), v("span", null, _(l == null ? void 0 : l.thickness), 1)]), _: 1 })) : u("", true), t(f).visible("material") ? (s(), r(c, { key: 1, prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true })) : u("", true), t(f).visible("plateWidth") ? (s(), r(c, { key: 2, prop: "plateWidth", label: "宽（mm）", align: "center", "min-width": "90" })) : u("", true), t(f).visible("plateHeight") ? (s(), r(c, { key: 3, prop: "plateHeight", label: "长（mm）", align: "center", "min-width": "90" })) : u("", true), t(f).visible("amount") ? (s(), r(c, { key: 4, prop: "amount", label: "数量（张）", align: "center", "min-width": "90" })) : u("", true), t(f).visible("partAmount") ? (s(), r(c, { key: 5, prop: "partAmount", label: "零件数量", align: "center" })) : u("", true), t(f).visible("utilization") ? (s(), r(c, { key: 6, prop: "utilization", label: "利用率", align: "center" }, { default: o(({ row: l }) => [v("span", null, _(l == null ? void 0 : l.utilization) + "%", 1)]), _: 1 })) : u("", true), t(f).visible("createTime") && t(a).query.cutSendStatus === t(b).NOT_ISSUED.V ? (s(), r(c, { key: 7, prop: "createTime", label: "套料日期", "min-width": "100", align: "center" }, { default: o(({ row: l }) => [l != null && l.createTime ? (s(), k("div", ht, [v("span", _t, _(t(oe)(l == null ? void 0 : l.createTime, "{y}-{m}-{d} {h}:{i}")), 1)])) : (s(), k("div", bt, _("-")))]), _: 1 })) : u("", true), t(a).query.cutSendStatus === t(b).HAS_ISSUED.V ? (s(), k(je, { key: 8 }, [t(f).visible("cutSendUserName") ? (s(), r(c, { key: 0, prop: "cutSendUserName", label: "排产人", align: "center" })) : u("", true), t(f).visible("cutSendTime") ? (s(), r(c, { key: 1, prop: "cutSendTime", label: "排产日期", align: "center", "min-width": "90" }, { default: o(({ row: l }) => [l != null && l.cutSendTime ? (s(), k("div", St, [v("span", kt, _(t(oe)(l == null ? void 0 : l.cutSendTime, "{y}-{m}-{d}")), 1)])) : (s(), k("div", It, _("-")))]), _: 1 })) : u("", true), t(f).visible("machineToolName") ? (s(), r(c, { key: 2, prop: "machineToolName", label: "已下发机床", align: "center", "min-width": "120" })) : u("", true), t(f).visible("fileName") ? (s(), r(c, { key: 3, prop: "fileName", label: "程序号", align: "center", "min-width": "140" })) : u("", true), t(f).visible("cutStatus") ? (s(), r(c, { key: 4, prop: "cutStatus", label: "状态", align: "center", "min-width": "90", fixed: "right" }, { default: o(({ row: l }) => [t(Xe)(l == null ? void 0 : l.cutStatus) ? (s(), k("div", Tt, [d(p, { type: t(ue).V[l.cutStatus].T }, { default: o(() => [h(_(t(ue).VL[l.cutStatus]), 1)]), _: 2 }, 1032, ["type"])])) : (s(), k("div", Dt, _("-")))]), _: 1 })) : u("", true)], 64)) : u("", true), d(c, { label: "操作", align: "center", width: "90", fixed: "right" }, { default: o(({ row: { sourceRow: l } }) => [t(A)(t(N).document) ? (s(), r(y, { key: 0, icon: "el-icon-view", type: "primary", onClick: (V) => ke(l) }, null, 8, ["onClick"])) : u("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name", "onSelectionChange"])), [[Le, (te = t(a)) == null ? void 0 : te.loading]])], 512), [[ie, (le = (ae = t(a)) == null ? void 0 : ae.query) == null ? void 0 : le.jobId]])]), d(t(rt), { visible: M.value, "onUpdate:visible": e[0] || (e[0] = (l) => M.value = l), "nesting-list": $.value }, null, 8, ["visible", "nesting-list"]), d(Ae, { "close-on-click-modal": false, "show-close": false, title: pe.value, visible: T.value, "append-to-body": "", width: "450px", "modal-class": [I.value === "delete" ? "nesting-result-v2-dialog-style" : ""], onClose: _e }, { default: o(() => [d(p, { size: "large", type: I.value === "produce" ? "success" : "danger", class: "dialog-tag-style" }, { default: o(() => [h(" 任务数（张）：" + _(fe.value), 1)]), _: 1 }, 8, ["type"]), I.value === "produce" ? (s(), r(W, { key: 0, ref_key: "formRef", ref: E, model: g.value, rules: ge, size: "default", "label-width": "100px" }, { default: o(() => [t(a).query.cutSendStatus === t(b).HAS_ISSUED.V ? (s(), r(U, { key: 0, label: "已下发机床：", prop: "machineToolName" }, { default: o(() => [d(p, { size: "large" }, { default: o(() => {
      var l, V;
      return [h(_(((V = (l = t(a).selections) == null ? void 0 : l[0]) == null ? void 0 : V.machineToolName) || "-"), 1)];
    }), _: 1 })]), _: 1 })) : u("", true), d(U, { label: "选择机床：", prop: "machineToolId" }, { default: o(() => [d(Y, { modelValue: g.value.machineToolId, "onUpdate:modelValue": e[1] || (e[1] = (l) => g.value.machineToolId = l), options: G.value, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "请选择机床", disabled: D.value, style: { width: "100%" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), d(U, { label: "完成日期：", prop: "finishDate" }, { default: o(() => [d(Re, { modelValue: g.value.finishDate, "onUpdate:modelValue": e[2] || (e[2] = (l) => g.value.finishDate = l), type: "date", size: "default", class: "date-item", style: { width: "100%" }, placeholder: "选择完成日期", clearable: false, format: "YYYY-MM-DD", "value-format": "x", disabled: D.value, "disabled-date": Ve }, null, 8, ["modelValue", "disabled"])]), _: 1 })]), _: 1 }, 8, ["model"])) : u("", true), I.value === "delete" ? (s(), k("div", xt, [d(W, { ref_key: "deleteFormRef", ref: L, model: q.value, rules: ye, size: "default", "label-width": "100px" }, { default: o(() => [d(U, { label: "删除范围：", prop: "deleteScope" }, { default: o(() => [d(Y, { modelValue: q.value.deleteScope, "onUpdate:modelValue": e[3] || (e[3] = (l) => q.value.deleteScope = l), type: "enum", options: t(Q).ENUM, placeholder: "选择删除范围", style: { width: "100%" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])])) : u("", true), v("div", Ct, [d(y, { size: "default", type: "info", onClick: e[4] || (e[4] = (l) => T.value = false) }, { default: o(() => e[11] || (e[11] = [h(" 取消 ")])), _: 1, __: [11] }), d(y, { size: "default", type: "primary", loading: D.value, onClick: Ce }, { default: o(() => e[12] || (e[12] = [h(" 确认 ")])), _: 1, __: [12] }, 8, ["loading"])])]), _: 1 }, 8, ["title", "visible", "modal-class"]), d(t(ct), { visible: P.value, "onUpdate:visible": e[5] || (e[5] = (l) => P.value = l), "drill-data": H.value, onSuccess: Ne, labelInfo: x.value, queryParams: ve.value, cutSendStatus: t(a).query.cutSendStatus }, null, 8, ["visible", "drill-data", "labelInfo", "queryParams", "cutSendStatus"])]);
  };
} }, Ht = Je(Nt, [["__scopeId", "data-v-d190bb37"]]);
export {
  Ht as default
};
