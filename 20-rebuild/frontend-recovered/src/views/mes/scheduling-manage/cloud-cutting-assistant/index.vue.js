import { ref as m } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as f } from "vue";
import { unref as e } from "vue";
import { createBlock as r } from "vue";
import { withCtx as c } from "vue";
import { createTextVNode as h } from "vue";
import { withModifiers as C } from "vue";
import { createCommentVNode as d } from "vue";
import { toDisplayString as b } from "vue";
import { withDirectives as ne } from "vue";
import { ElMessage as F } from "element-plus";
import { ElMessageBox as ie } from "element-plus";
import { ElTag as re } from "element-plus";
import { ElTableColumn as ue } from "element-plus";
import { vLoading as ce } from "element-plus";
import { c as de, d as me, g as pe } from "../../../../modules/cloud-cutting-assistant-43dc84e4.js";
import { _ as fe, x as ye, qv as v, o as he, G as I, qw as ge, qx as S, qy as j, P as ve, aw as _e, oT as Te, cf as be } from "../../../../shared/runtime.js";
import Se from "./module/header.vue.js";
import ke from "./module/project-list.vue.js";
import we from "./module/task-issue-form.vue.js";
import Ce from "./module/task-import-form.vue.js";
import Ie from "./module/batch-task-issue-form.vue.js";
import "./module/create-project-form.vue.js";
import "./module/create-order-form.vue.js";
import "./component/drawing-upload-btn.vue.js";
import "../../../../modules/index-ce9deea8.js";
const xe = { class: "app-container wrap" }, Ne = { class: "wrap-left" }, Ve = { class: "wrap-right" }, De = { key: 1 }, Le = { class: "head-container" }, Ue = { key: 1 }, Ee = { __name: "index", setup(Be) {
  const $ = { add: false, edit: false, del: false, download: false }, K = m(), x = m(), _ = m([]), T = m([]), G = m([["importTime", ["parse-time", "{y}-{m}-{d}"]], ["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["cutSendTime", ["parse-time", "{y}-{m}-{d}"]]]), q = m(0), k = m({}), N = m(false), A = m({}), V = m(false), D = m(false), L = m(false), { crud: u, CRUD: O, columns: p } = ye({ title: "云切助手", sort: [], permission: { ...v }, optShow: { ...$ }, crudApi: { ...de }, invisibleColumns: ["issueUserName", "askCompleteTime", "cutSendTime"], hasPagination: true, requiredQuery: ["cloudcutId"] }, x), { maxHeight: U } = he({ paginate: true }), J = /* @__PURE__ */ new Map([["machineToolId", -1]]), W = { machineToolId: [{ required: true, message: "请选择数控机床", trigger: "change" }] }, { tableValidate: z, cleanUpData: P, wrongCellMask: X } = _e({ rules: W, ditto: J });
  async function Y() {
    var n, i;
    const { validResult: a } = z(T.value);
    if (!a) return;
    P(T.value);
    const t = (i = (n = T.value) == null ? void 0 : n.filter((s) => s.machineToolId && s.machineToolId !== -1)) == null ? void 0 : i.map((s) => s.machineToolId);
    if (Array.from(new Set(t)) && Array.from(new Set(t)).length > 1) {
      F.error("请选择相同的数控机床进行下发！");
      return;
    }
    V.value = true;
  }
  async function Z() {
    await ie.confirm("是否确认删除？一旦执行此操作将无法撤回!", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true, closeOnClickModal: false }).then(async () => {
      var t;
      D.value = true;
      const a = (t = u.selections) == null ? void 0 : t.map((n) => n.id);
      await me(a), u.toQuery(), F.success("删除成功");
    }).catch((a) => {
      console.log(a, "删除失败");
    }).finally(() => {
      D.value = false;
    });
  }
  function ee(a, t) {
    var n;
    t.machineToolId = a, t.machineToolName = (n = _.value.find((i) => i.id === a)) == null ? void 0 : n.name, T.value = [...u.selections];
  }
  async function te(a) {
    var t;
    await ((t = x.value) == null ? void 0 : t.toggleRowSelection(a, false));
  }
  async function ae(a) {
    var t, n;
    try {
      const i = await pe({ partProdMode: Te.NUMERICAL_CONTROL.V, partType: a && a.length > 0 ? (t = a[0]) == null ? void 0 : t.partType : void 0, processType: be.MAKINGS.V, workshopId: (n = k.value) == null ? void 0 : n.workshopId });
      _.value = i == null ? void 0 : i.map((s) => ({ id: s.id, name: s.deviceName }));
    } catch (i) {
      console.log(i, "获取数控机床的列表的数据失败");
    }
  }
  O.HOOK.beforeToQuery = () => {
  }, O.HOOK.handleRefresh = async (a, t) => {
    var n, i;
    t.data.content = (n = t.data.content) == null ? void 0 : n.map((s, E) => {
      var w;
      return { ...s, cutSendStatus: !!s.cutSendStatus, machineToolName: (w = _.value.find((B) => B.id === s.machineToolId)) == null ? void 0 : w.name, machineToolId: E === 0 ? void 0 : -1 };
    }), q.value = (i = t.data) == null ? void 0 : i.totalElements, await ae(t.data.content);
  };
  async function oe(a) {
    const { validResult: t, dealList: n } = z([a]);
    t && (P(n), A.value = a, N.value = true);
  }
  function se(a) {
    a.isLeaf && (a != null && a.id) ? u.query.cloudcutId = a == null ? void 0 : a.id : u.query.cloudcutId = void 0, k.value = a || {}, u.toQuery();
  }
  function le(a) {
    return !!a.cutSendStatus !== S.HAS_ISSUED.V;
  }
  return (a, t) => {
    var Q;
    const n = re, i = R("common-button"), s = ue, E = R("common-select"), w = R("common-table"), B = ce;
    return l(), H("div", xe, [g("div", Ne, [f(e(ke), { ref_key: "projectListRef", ref: K, permission: e(v), maxHeight: e(U), onOrderClick: se }, null, 8, ["permission", "maxHeight"])]), g("div", Ve, [(Q = e(u).query) != null && Q.cloudcutId ? (l(), H("div", De, [g("div", Le, [f(Se, null, { operateBtn: c(() => {
      var o, y;
      return [e(I)(e(v).taskDel) ? (l(), r(i, { key: 0, class: "filter-item", disabled: !((o = e(u).selections) != null && o.length), type: "danger", size: "default", loading: D.value, onClick: C(Z, ["stop"]) }, { default: c(() => t[5] || (t[5] = [h(" 任务删除 ")])), _: 1, __: [5] }, 8, ["disabled", "loading"])) : d("", true), e(I)(e(v).batchAllot) ? (l(), r(i, { key: 1, class: "filter-item", disabled: !((y = e(u).selections) != null && y.length), type: "success", size: "default", onClick: C(Y, ["stop"]) }, { default: c(() => t[6] || (t[6] = [h(" 任务下发 ")])), _: 1, __: [6] }, 8, ["disabled"])) : d("", true)];
    }), importBtn: c(() => [e(I)(e(v).import) ? (l(), r(i, { key: 0, class: "filter-item", type: "warning", size: "default", onClick: t[0] || (t[0] = C((o) => L.value = true, ["stop"])) }, { default: c(() => t[7] || (t[7] = [h("导入文件")])), _: 1, __: [7] })) : d("", true), f(n, { size: "large", class: "filter-item", style: { "margin-left": "5px" }, effect: "plain" }, { default: c(() => [t[8] || (t[8] = g("span", null, "文件数量：", -1)), g("span", null, b(q.value || 0), 1)]), _: 1, __: [8] })]), _: 1 })]), ne((l(), r(w, { ref_key: "tableRef", ref: x, data: e(u).data, "empty-text": e(u).emptyText, "max-height": e(U) - 10, style: { width: "100%" }, "row-key": "id", returnSourceData: "", dataFormat: G.value, "cell-class-name": e(X), onSelectionChange: e(u).selectionChangeHandler }, { default: c(() => [f(s, { type: "selection", width: "55", selectable: le, align: "center" }), e(p).visible("index") ? (l(), r(s, { type: "index", key: "index", prop: "index", label: "序号", width: "55", align: "center" })) : d("", true), e(p).visible("importTime") ? (l(), r(s, { key: "importTime", prop: "importTime", label: "导入日期", align: "center", "show-overflow-tooltip": true })) : d("", true), e(p).visible("importUserName") ? (l(), r(s, { key: "importUserName", prop: "importUserName", label: "导入人", align: "center", "show-overflow-tooltip": true })) : d("", true), e(p).visible("fileName") ? (l(), r(s, { key: "fileName", prop: "fileName", "show-overflow-tooltip": true, label: "文件名称", align: "center", "min-width": "140px" })) : d("", true), e(p).visible("partType") ? (l(), r(s, { key: "partType", prop: "partType", align: "center", "show-overflow-tooltip": true, label: "零件类型" }, { default: c(({ row: o }) => [g("span", null, b(e(ge).VL[o.partType]), 1)]), _: 1 })) : d("", true), e(p).visible("machineToolId") ? (l(), r(s, { key: "machineToolId", prop: "machineToolId", label: "数控机床", align: "center", "show-overflow-tooltip": true, "min-width": "160px" }, { default: c(({ row: o, $index: y }) => [!!o.cutSendStatus !== e(S).HAS_ISSUED.V ? (l(), r(E, { key: 0, modelValue: o.machineToolId, "onUpdate:modelValue": (M) => o.machineToolId = M, options: _.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "数控机床", "show-extra": y !== 0, style: { width: "100%" }, onChange: (M) => ee(M, o) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra", "onChange"])) : (l(), H("span", Ue, b(o.machineToolName), 1))]), _: 1 })) : d("", true), e(p).visible("issueUserName") ? (l(), r(s, { key: "issueUserName", prop: "issueUserName", label: "下发人", align: "center", "show-overflow-tooltip": true })) : d("", true), e(p).visible("cutSendTime") ? (l(), r(s, { key: "cutSendTime", prop: "cutSendTime", label: "下发日期", align: "center", "show-overflow-tooltip": true })) : d("", true), e(p).visible("askCompleteTime") ? (l(), r(s, { key: "askCompleteTime", prop: "askCompleteTime", label: "完成日期", align: "center", "show-overflow-tooltip": true })) : d("", true), e(p).visible("cutSendStatus") ? (l(), r(s, { key: "cutSendStatus", prop: "cutSendStatus", label: "下发状态", align: "center" }, { default: c(({ row: o }) => {
      var y;
      return [f(n, { type: (y = e(S).V[o.cutSendStatus]) == null ? void 0 : y.T, size: "default" }, { default: c(() => [h(b(e(S).VL[o.cutSendStatus]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : d("", true), e(p).visible("cutStatus") ? (l(), r(s, { key: "cutStatus", prop: "cutStatus", label: "切割状态", align: "center" }, { default: c(({ row: o }) => [f(n, { type: e(j).V[o.cutStatus].T, size: "default" }, { default: c(() => [h(b(e(j).VL[o.cutStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : d("", true), e(I)(e(v).allot) ? (l(), r(s, { key: 11, label: "操作", width: "100", align: "center" }, { default: c(({ row: o }) => [f(i, { class: "filter-item", size: "default", type: "success", disabled: !!o.cutSendStatus === e(S).HAS_ISSUED.V, onClick: C((y) => oe(o), ["stop"]) }, { default: c(() => t[9] || (t[9] = [h("下发")])), _: 2, __: [9] }, 1032, ["disabled", "onClick"])]), _: 1 })) : d("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "dataFormat", "cell-class-name", "onSelectionChange"])), [[B, e(u).loading]]), f(e(ve)), f(Ce, { visible: L.value, "onUpdate:visible": t[1] || (t[1] = (o) => L.value = o), orderId: e(u).query.cloudcutId, onSuccess: e(u).toQuery }, null, 8, ["visible", "orderId", "onSuccess"]), f(we, { visible: N.value, "onUpdate:visible": t[2] || (t[2] = (o) => N.value = o), "current-row": A.value, currentTreeData: k.value, onSuccess: e(u).toQuery }, null, 8, ["visible", "current-row", "currentTreeData", "onSuccess"]), f(Ie, { visible: V.value, "onUpdate:visible": t[3] || (t[3] = (o) => V.value = o), selections: T.value, currentTreeData: k.value, machineList: _.value, maxHeight: e(U), onDelChange: te, onSuccess: e(u).toQuery }, null, 8, ["visible", "selections", "currentTreeData", "machineList", "maxHeight", "onSuccess"])])) : (l(), r(n, { key: 0, type: "info", size: "large" }, { default: c(() => t[4] || (t[4] = [h(" * 请先选择工单号 ")])), _: 1, __: [4] }))])]);
  };
} }, Ge = fe(Ee, [["__scopeId", "data-v-2a7a7434"]]);
export {
  Ge as default
};
