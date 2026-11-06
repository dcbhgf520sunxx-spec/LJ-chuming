import { ref as g } from "vue";
import { provide as ee } from "vue";
import { resolveComponent as C } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as A } from "vue";
import { createElementVNode as b } from "vue";
import { createVNode as h } from "vue";
import { unref as a } from "vue";
import { withDirectives as D } from "vue";
import { vShow as P } from "vue";
import { withCtx as m } from "vue";
import { createTextVNode as k } from "vue";
import { createBlock as p } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as _ } from "vue";
import { ElMessageBox as te } from "element-plus";
import { ElMessage as R } from "element-plus";
import { ElTag as Se } from "element-plus";
import { ElTableColumn as Ne } from "element-plus";
import { vLoading as Ce } from "element-plus";
import { _ as xe, x as Ve, ra as q, rs as Ee, o as De, az as Re, qy as E, G as ae, qx as L, p as qe, aw as Le, rt as Ue, ru as He, ri as je, rv as Me, qR as Be, oT as Oe, qw as ze, cf as Ae } from "../../../../../shared/runtime.js";
import Pe from "./module/header.vue.js";
import Ge from "./module/nesting-task-list.vue.js";
import Qe from "./module/part-dialog.vue.js";
import Ke from "./module/nesting-document-dialog.vue.js";
import Je from "./module/produce-drawer.vue.js";
import We from "./module/machine-status-drawer.vue.js";
import "./module/nesting-detail.vue.js";
import "../../../../../modules/common-a5dc7899.js";
import "../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../modules/artifact-f1b0ca44.js";
import "./module/drill-scheduling-dialog.vue.js";
import "../../../../../modules/print-e379c493.js";
const $e = { class: "app-container wrap" }, Fe = { class: "wrap-left" }, Xe = { class: "wrap-right" }, Ye = { class: "head-container" }, Ze = { key: 0 }, we = { style: { "font-size": "12px" } }, et = { key: 1 }, tt = { __name: "index", setup(at) {
  const G = g(false), Q = g({});
  g(false);
  const U = g(false), H = g(false), K = g(false);
  g([]);
  const le = g([]), o = g([]), j = g([]), y = g({}), M = g([]);
  g(false);
  const ne = /* @__PURE__ */ new Map([["machineToolId", "同上"]]), se = { machineToolId: [{ required: true, message: "请选择机床", trigger: "change" }] }, { tableValidate: ie, cleanUpData: lt, wrongCellMask: oe } = Le({ rules: se, ditto: ne }), x = { SCHEDULING: { K: "SCHEDULING", L: "排产模式", V: 1 }, EDIT: { K: "EDIT", L: "编辑模式", V: 2 } }, V = g(x.SCHEDULING.V), ue = { add: false, edit: false, del: false, download: false }, T = g(), { crud: n, columns: v, CRUD: B } = Ve({ title: "套料成果", sort: [], permission: { ...q }, optShow: { ...ue }, crudApi: { get: Ee }, invisibleColumns: [""], hasPagination: false, requiredQuery: ["jobId"], queryOnPresenterCreated: false }, T);
  ee("crud", n), ee("permission", q);
  const { maxHeight: J, heightStyle: de } = De({ extraBox: [".head-container"], paginate: false }), O = g(), z = (i) => !!i.cutSendStatus === L.NOT_ISSUED.V, re = async () => {
    te.confirm("确认删除选中的数据？删除后无法恢复，请谨慎操作，是否确认删除？", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false }).then(async () => {
      const e = { resultList: o.value.map((s) => s.guid), jobId: o.value[0].jobId };
      await Ue({ ...e }), R({ type: "success", message: "删除成功" }), n.data.length ? n.toQuery() : (O.value.refresh(), n.query.jobId = void 0);
    }).catch(() => {
    });
  }, ce = () => {
    te.confirm("您选择了删除该批零件，数据将恢复到【零件排产】页面，是否确认？", "温馨提示", { confirmButtonText: "确定", cancelButtonText: "取消", showClose: false }).then(async () => {
      await He({ jobId: n.query.jobId }), R({ type: "success", message: "删除成功" }), O.value.refresh(), n.query.jobId = void 0;
    }).catch(() => {
    });
  };
  function me() {
    T.value.clearSelection(), o.value = [], n.selectionChangeHandler(o.value);
  }
  const pe = async () => {
    var c;
    const i = o.value.map((d) => d), { validResult: e, dealList: s } = ie(i);
    if (e) {
      const d = s[0];
      if (s.every((l) => l.machineToolId === d.machineToolId)) {
        y.value.teamName = (c = M.value.filter((u) => u.id === d.machineToolId)[0]) == null ? void 0 : c.teamName;
        const l = await je({ jobId: n.query.jobId });
        if (y.value.artifactAskCompleteTime = l[0].artifactAskCompleteTime, s.every((u) => u.thickness === d.thickness && u.material === d.material)) H.value = true;
        else {
          R({ type: "error", message: "相同的厚度和材质才能一起排产" });
          return;
        }
      } else {
        R({ type: "error", message: "相同的机床才能一起排产" });
        return;
      }
    } else return e;
  }, fe = (i) => {
    U.value = true, Q.value = i;
  };
  function ge(i, e, s) {
    var d, l, u;
    const c = M.value.filter((S) => S.id === e.machineToolId);
    y.value.downConfigId = (d = c[0]) == null ? void 0 : d.id, y.value.workshopName = (l = c[0]) == null ? void 0 : l.workshopName, e.deviceName = (u = c[0]) == null ? void 0 : u.deviceTypeName;
  }
  async function ve({ node: i, cutState: e }) {
    var s, c;
    if (n.query.jobId = ((s = i[0]) == null ? void 0 : s.jobId) || void 0, console.log(n.query.jobId, i, "crud.query.jobId"), n.query.cutStatus = e, y.value = i[0] || {}, n.query.jobId) {
      console.log("handleNestingTaskClick++++++++++++"), n.toQuery(), be(Number((c = i[0]) == null ? void 0 : c.workshopId));
      const d = await Me({ jobId: n.query.jobId });
      y.value.amount = d.partQuantity, y.value.nestingQuantity = d.nestingQuantity, y.value.cutQuantity = d.cutQuantity;
    }
  }
  const he = (i) => {
    if (V.value === x.EDIT.V) {
      if (i.length > o.value.length || o.value.length === 0) {
        let e = null;
        o.value.length === 0 ? e = i[0] : e = i.filter((u) => !o.value.some((S) => S.material === u.material && S.thickness === u.thickness))[0];
        const { material: s, thickness: c } = e, d = n.data.filter((u) => u.material === s && u.thickness === c && z(u));
        d.forEach((u) => {
          T.value.toggleRowSelection(u, true);
        });
        const l = /* @__PURE__ */ new Set([...o.value, ...d]);
        o.value = Array.from(l), n.selectionChangeHandler(o.value), n.selections.sort((u, S) => u.orderIndex - S.orderIndex);
      } else if (o.value.length > 0) {
        let e = null;
        if (e = o.value.filter((s) => !i.some((c) => c.id === s.id)), e.length === 0) T.value.clearSelection(), o.value = [], n.selectionChangeHandler(o.value), n.selections.sort((s, c) => s.orderIndex - c.orderIndex);
        else {
          const { material: s, thickness: c } = e[0], d = n.data.filter((l) => l.material === s && l.thickness === c && z(l));
          d.forEach((l) => {
            T.value.toggleRowSelection(l, false);
          }), o.value = o.value.filter((l) => !d.some((u) => u.id === l.id)), n.selectionChangeHandler(o.value), n.selections.sort((l, u) => l.orderIndex - u.orderIndex);
        }
      }
    } else o.value = i, n.selectionChangeHandler(i), n.selections.sort(function(e, s) {
      return e.orderIndex - s.orderIndex;
    });
  }, be = async (i) => {
    try {
      const e = await Be({ partProdMode: Oe.NUMERICAL_CONTROL.V, partType: ze.BOARD.V, processType: Ae.MAKINGS.V });
      M.value = e, j.value = e.map((s) => ({ name: s.deviceName, id: s.id }));
    } catch (e) {
      console.log(e);
    }
  };
  function ye({ list: i }) {
    o.value = o.value.filter((e) => !i.some((s) => s.id === e.id)), i.forEach((e) => {
      T.value.toggleRowSelection(e, false);
    });
  }
  function _e({ row: i }) {
    const e = o.value.findIndex((s) => s.id === i.id);
    o.value.splice(e, 1), T.value.toggleRowSelection(i, false);
  }
  return B.HOOK.handleRefresh = (i, e) => {
    e.data.content = e.data.map((s, c) => (s.orderIndex = c + 1, s));
  }, B.HOOK.afterRefresh = (i, e) => {
    e.length && i.query.jobId;
  }, B.HOOK.beforeToQuery = async () => {
    n.query.boolNestCutEnum = Re.NESTING.V;
  }, (i, e) => {
    var W, $, F, X, Y, Z, w;
    const s = Se, c = C("common-radio-button"), d = C("common-button"), l = Ne, u = C("table-cell-tag"), S = C("common-select"), Ie = C("common-tip-button"), ke = C("common-table"), Te = Ce;
    return r(), A("div", $e, [b("div", Fe, [h(Ge, { ref_key: "nestingTaskRef", ref: O, heightStyle: a(de), maxHeight: a(J) - 40, onNestingTaskClick: ve }, null, 8, ["heightStyle", "maxHeight"])]), b("div", Xe, [D(h(s, { type: "info", size: "large" }, { default: m(() => e[5] || (e[5] = [k(" * 请先选择套料任务，进行零件任务下发 ")])), _: 1, __: [5] }, 512), [[P, !(($ = (W = a(n)) == null ? void 0 : W.query) != null && $.jobId)]]), D(b("div", null, [b("div", Ye, [h(a(Pe), { labelInfo: y.value }, { header: m(() => e[6] || (e[6] = [])), right: m(() => [b("span", null, [h(c, { modelValue: V.value, "onUpdate:modelValue": e[0] || (e[0] = (t) => V.value = t), size: "default", options: x, type: "enum", class: "filter-item", style: { "margin-bottom": "0" }, onChange: me }, null, 8, ["modelValue"]), h(d, { class: "filter-item", size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-bottom": "0" }, disabled: a(n).query.cutStatus !== a(E).IN_NESTING.V, onClick: ce }, { default: m(() => e[7] || (e[7] = [k(" 排产单删除 ")])), _: 1, __: [7] }, 8, ["disabled"]), V.value === x.EDIT.V ? (r(), p(d, { key: 0, class: "filter-item", size: "default", type: "danger", icon: "el-icon-delete", style: { "margin-bottom": "0" }, disabled: o.value.length === 0, onClick: re }, { default: m(() => e[8] || (e[8] = [k(" 作业单删除 ")])), _: 1, __: [8] }, 8, ["disabled"])) : f("", true), a(ae)(a(q).scheduling) ? D((r(), p(d, { key: 1, class: "filter-item", size: "default", type: "success", icon: "el-icon-document", style: { "margin-bottom": "0" }, disabled: !o.value.length || a(n).query.cutStatus !== a(E).IN_NESTING.V, onClick: pe }, { default: m(() => e[9] || (e[9] = [k(" 生产排产 ")])), _: 1, __: [9] }, 8, ["disabled"])), [[P, V.value === x.SCHEDULING.V]]) : f("", true)])]), _: 1 }, 8, ["labelInfo"])]), D((r(), p(ke, { ref_key: "tableRef", ref: T, data: (F = a(n)) == null ? void 0 : F.data, "empty-text": (X = a(n)) == null ? void 0 : X.emptyText, "max-height": a(J), "cell-class-name": a(oe), style: { width: "100%" }, id: "listTabless", onSelectionChange: he }, { default: m(() => [h(l, { type: "selection", width: "50", align: "center", selectable: z }), h(l, { label: "序号", type: "index", align: "center" }), a(v).visible("thickness") ? (r(), p(l, { key: 0, prop: "thickness", label: "厚度", align: "center" }, { default: m(({ row: t }) => [t != null && t.isMixNest ? (r(), p(u, { key: 0, name: "混套", color: "#67C23A", offset: 10 })) : f("", true), b("span", null, _(t == null ? void 0 : t.thickness), 1)]), _: 1 })) : f("", true), a(v).visible("material") ? (r(), p(l, { key: 1, prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true })) : f("", true), a(v).visible("partAmount") ? (r(), p(l, { key: 2, prop: "partAmount", label: "零件数量", align: "center" })) : f("", true), a(v).visible("quantity") ? (r(), p(l, { key: 3, prop: "quantity", label: "原材料规格", align: "center" }, { default: m(() => [a(v).visible("plateWidth") ? (r(), p(l, { key: 0, prop: "plateWidth", label: "宽（mm）", align: "center", width: "100" })) : f("", true), a(v).visible("plateHeight") ? (r(), p(l, { key: 1, prop: "plateHeight", label: "长（mm）", align: "center", width: "100" })) : f("", true), a(v).visible("amount") ? (r(), p(l, { key: 2, prop: "amount", label: "数量（张）", align: "center", width: "100" })) : f("", true)]), _: 1 })) : f("", true), a(v).visible("utilization") ? (r(), p(l, { key: 4, prop: "utilization", label: "利用率", align: "center" }, { default: m(({ row: t }) => [b("span", null, _(t == null ? void 0 : t.utilization) + "%", 1)]), _: 1 })) : f("", true), a(v).visible("machineToolId") ? (r(), p(l, { key: 5, prop: "machineToolId", label: "选择机床", width: "150", align: "center" }, { default: m(({ row: { sourceRow: t }, $index: N }) => [h(S, { modelValue: t.machineToolId, "onUpdate:modelValue": (I) => t.machineToolId = I, options: j.value, "data-structure": { key: "id", label: "name", value: "id" }, placeholder: "请选择机床", disabled: (t == null ? void 0 : t.cutSendStatus) !== a(E).IN_NESTING.V, style: { width: "100%" }, onChange: (I) => ge(I, t, N) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled", "onChange"])]), _: 1 })) : f("", true), a(v).visible("cutSendStatus") ? (r(), p(l, { key: 6, label: "下发状态", align: "center", width: "80" }, { default: m(({ row: t }) => {
      var N;
      return [h(s, { effect: "plain", type: (N = a(L).V) == null ? void 0 : N[!!(t != null && t.cutSendStatus)].T }, { default: m(() => {
        var I;
        return [k(_((I = a(L).VL) == null ? void 0 : I[!!(t != null && t.cutSendStatus)]), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : f("", true), a(v).visible("cutStatus") ? (r(), p(l, { key: 7, label: "任务状态", width: "90", align: "center" }, { default: m(({ row: t }) => {
      var N;
      return [h(s, { effect: "plain", type: (N = a(E).V) == null ? void 0 : N[t.cutStatus].T }, { default: m(() => {
        var I;
        return [k(_((I = a(E).VL) == null ? void 0 : I[t == null ? void 0 : t.cutStatus]), 1)];
      }), _: 2 }, 1032, ["type"])];
    }), _: 1 })) : f("", true), a(v).visible("taskRate") ? (r(), p(l, { key: 8, label: "切割进度", align: "center" }, { default: m(({ row: t }) => [b("span", null, _((t == null ? void 0 : t.taskRate) || 0) + "%", 1)]), _: 1 })) : f("", true), a(v).visible("nestJobName") ? (r(), p(l, { key: 9, label: "所属作业", align: "center", "show-overflow-tooltip": true }, { default: m(({ row: t }) => [b("span", null, _(t == null ? void 0 : t.nestJobName), 1)]), _: 1 })) : f("", true), a(v).visible("nestUserId") ? (r(), p(l, { key: 10, prop: "nestUserId", label: "套料人", width: "90", align: "center" }, { default: m(({ row: t }) => [b("span", null, _(t == null ? void 0 : t.nestUserId), 1), e[10] || (e[10] = k()), e[11] || (e[11] = b("br", null, null, -1))]), _: 1 })) : f("", true), a(v).visible("cutSendUserName") ? (r(), p(l, { key: 11, prop: "cutSendUserName", label: "排产人", width: "90", align: "center" }, { default: m(({ row: t }) => [!!(t != null && t.cutSendStatus) !== a(L).NOT_ISSUED.V ? (r(), A("div", Ze, [b("span", null, _(t.cutSendUserName), 1), e[12] || (e[12] = k()), e[13] || (e[13] = b("br", null, null, -1)), b("span", we, _(a(qe)(t == null ? void 0 : t.createTime, "{y}-{m}-{d} {h}:{i}")), 1)])) : (r(), A("div", et, _("-")))]), _: 1 })) : f("", true), h(l, { label: "操作", align: "center", width: "90", fixed: "right" }, { default: m(({ row: { sourceRow: t } }) => [a(ae)(a(q).document) ? (r(), p(Ie, { key: 0, content: "选择机床后才能查看", "show-tip": "", size: "default", type: "primary", onClick: (N) => fe(t) }, { default: m(() => e[14] || (e[14] = [k(" 查看 ")])), _: 2, __: [14] }, 1032, ["onClick"])) : f("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name"])), [[Te, (Y = a(n)) == null ? void 0 : Y.loading]])], 512), [[P, (w = (Z = a(n)) == null ? void 0 : Z.query) == null ? void 0 : w.jobId]]), h(Qe, { visible: G.value, "onUpdate:visible": e[1] || (e[1] = (t) => G.value = t), "part-list": le.value }, null, 8, ["visible", "part-list"]), h(Ke, { visible: U.value, "onUpdate:visible": e[2] || (e[2] = (t) => U.value = t), "nesting-list": Q.value }, null, 8, ["visible", "nesting-list"]), h(Je, { visible: H.value, "onUpdate:visible": e[3] || (e[3] = (t) => H.value = t), list: o.value, labelInfo: y.value, machineList: j.value, onSuccess: a(n).toQuery, onHandleDel: _e, onHandleBatchDel: ye }, null, 8, ["visible", "list", "labelInfo", "machineList", "onSuccess"]), h(a(We), { visible: K.value, "onUpdate:visible": e[4] || (e[4] = (t) => K.value = t) }, null, 8, ["visible"])])]);
  };
} }, yt = xe(tt, [["__scopeId", "data-v-f53affa3"]]);
export {
  yt as default
};
