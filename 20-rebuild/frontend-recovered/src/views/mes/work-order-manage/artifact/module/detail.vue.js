import { inject as We } from "vue";
import { ref as u } from "vue";
import { computed as je } from "vue";
import { watch as ce } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as He } from "vue";
import { openBlock as v } from "vue";
import { createBlock as y } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as c } from "vue";
import { toDisplayString as w } from "vue";
import { unref as o } from "vue";
import { createElementVNode as D } from "vue";
import { withKeys as pe } from "vue";
import { withModifiers as R } from "vue";
import { withDirectives as S } from "vue";
import { vShow as K } from "vue";
import { createCommentVNode as O } from "vue";
import { isRef as Ge } from "vue";
import { ElMessage as de } from "element-plus";
import { ElMessageBox as Qe } from "element-plus";
import { ElNotification as ee } from "element-plus";
import { ElLoading as $e } from "element-plus";
import { ElTag as Je } from "element-plus";
import { ElDatePicker as Xe } from "element-plus";
import { ElInput as Ye } from "element-plus";
import { ElCheckbox as Ze } from "element-plus";
import { ElPopover as et } from "element-plus";
import { ElTableColumn as tt } from "element-plus";
import { ElPopconfirm as at } from "element-plus";
import { ElPagination as lt } from "element-plus";
import { _ as ot, u as nt, J as it, a3 as d, n as rt, o as st, c as ut, D as ct, p as fe, b$ as me, cj as pt, $ as te, cl as dt, bg as ft } from "../../../../../shared/runtime.js";
import { p as mt, g as vt, b as ve, a as yt, d as gt, e as ht, f as ye } from "../../../../../modules/artifact-da890fbc.js";
import { u as wt } from "../../../../../modules/use-default-table-template-4b5e02c6.js";
const _t = { class: "head-container" }, bt = { style: { float: "right" } }, Tt = { style: { "text-align": "right", margin: "0" } }, kt = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, serialNumber: { type: String } }, emits: ["update:visible", "refresh"], setup(ge, { emit: he }) {
  const _ = We("permission"), ae = u(), f = u(false), V = u(false), G = u(), Q = u([]), $ = u(), M = u(), A = u(false), E = he, n = ge, { visible: q, handleClose: we } = nt({ emit: E, props: n, field: "visible" }), { handleSizeChange: _e, handleCurrentChange: be, total: Te, setTotalPage: le, queryPage: F } = it({ fetchHook: I }), b = { TASK_LIST: { L: "任务清单", K: "TASK_LIST", V: 1, [d.ARTIFACT.K]: "mesProductionTaskOrder", [d.ASSEMBLE.K]: "mesAssembleProductionTaskOrder" }, NESTING_LIST: { L: "套料清单", K: "NESTING_LIST", V: 2, [d.ASSEMBLE.K]: "mesAssembleNestingOrder" } };
  rt(b);
  function ke() {
    f.value = true, Re();
  }
  function Ce() {
    f.value = false;
  }
  function Se(t) {
    Q.value = t;
  }
  const { maxHeight: J } = st({ extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true }, ae), U = u([]), oe = u([]), L = u(), T = u([]), W = u(), j = u(), H = u(), k = u(b.TASK_LIST.V), g = je(() => ({ orderId: n.detailData.orderId, processId: L.value, productType: n.detailData.productType, projectId: n.detailData.projectId, serialNumber: W.value, specification: j.value, boolAccurateQuery: H.value }));
  ce(() => q.value, (t) => {
    t && (f.value = false, k.value = b.TASK_LIST.V, L.value = void 0, Le()), E("refresh");
  }, { deep: true, immediate: true }), ce(() => L.value, (t) => {
    t && (f.value = false);
  });
  function Ee() {
    L.value = void 0, W.value = void 0, j.value = void 0, H.value = false, I();
  }
  async function Le() {
    var t;
    try {
      const e = await mt({ orderId: n.detailData.orderId, productionLineId: (t = n.detailData.productionLine) == null ? void 0 : t.id });
      oe.value = e, X();
    } catch (e) {
      console.log("获取工序", e);
    }
  }
  async function N() {
    var e;
    $.value = 0, M.value = 0;
    let t = [];
    try {
      const s = n.detailData.productType === d.ARTIFACT.V ? { ...g.value, productionLineTypeEnum: (e = n.detailData.productionLine) == null ? void 0 : e.productionLineTypeEnum, startDate: T.value ? T.value[0] : void 0, endDate: T.value ? T.value[1] : void 0 } : { ...g.value, type: k.value, startDate: T.value[0], endDate: T.value[1] }, { content: x = [], totalElements: B } = await vt({ ...s, ...F });
      x.forEach((p) => {
        p.pop = false, $.value += p.quantity, M.value += p.totalNetWeight;
      }), le(B), t = x.map((p) => (p.totalLength = Number(p.length) * Number(p.quantity), p)), console.log(t);
    } catch (s) {
      console.log("获取生产任务单", s);
    } finally {
      U.value = t;
    }
  }
  function De(t) {
    t.pop = true;
  }
  function Ve(t) {
    t.pop = false;
  }
  async function Ae(t) {
    A.value = true;
    const e = [];
    e.push(t.taskId);
    try {
      await ve(e), E("refresh"), N(), de.success("当前工单撤回成功");
    } catch (s) {
      console.log("撤回工单操作失败", s);
    } finally {
      A.value = false;
    }
  }
  async function Ie() {
    var e;
    A.value = true;
    const t = [];
    (e = Q.value) == null || e.forEach((s) => {
      t.push(s.taskId);
    });
    try {
      await ve(t), E("refresh"), N(), de.success("工单批量撤回成功");
    } catch (s) {
      console.log("撤回操作失败", s);
    } finally {
      V.value = false, A.value = false;
    }
  }
  function xe() {
    V.value = true;
  }
  function Ne() {
    V.value = false;
  }
  function ne() {
    V.value = false;
  }
  function ze() {
    setTimeout(() => {
      document.addEventListener("click", ne, { passive: false });
    }, 0);
  }
  function Be() {
    document.removeEventListener("click", ne);
  }
  function Pe(t) {
    return t.boolCanRevoke !== false;
  }
  async function Re() {
    var t;
    try {
      const e = await yt({ ...g.value, productionLineTypeEnum: (t = n.detailData.productionLine) == null ? void 0 : t.productionLineTypeEnum });
      G.value = e;
    } catch (e) {
      console.log("获取整个工单是否可撤回失败", e);
    }
  }
  async function Ke() {
    G.value && Qe.confirm("是否确认撤回整个工单？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      try {
        await gt(n.detailData.orderId), ee({ title: "删除整个工单成功", type: "success" }), E("refresh"), N();
      } catch (t) {
        console.log("删除模型失败", t);
      }
    });
  }
  async function ie() {
    let t = [];
    try {
      const { content: e = [], totalElements: s } = await ht({ ...g.value, type: k.value, ...F });
      le(s), t = e;
    } catch (e) {
      console.log("获取部件套料清单", e);
    } finally {
      U.value = t;
    }
  }
  function X(t) {
    k.value === b.TASK_LIST.V ? N() : ie();
  }
  function I() {
    f.value = false, k.value === b.TASK_LIST.V ? N() : ie();
  }
  async function re() {
    if (n.detailData.productType === d.ARTIFACT.V) try {
      await ye({ ...g.value }), E("refresh");
    } catch (t) {
      console.log("添加打印记录失败", t);
    }
  }
  const z = u();
  async function Oe() {
    var t;
    z.value = $e.service({ lock: true, text: "正在准备加入打印队列", spinner: "el-icon-loading", fullscreen: true });
    try {
      const e = n.detailData.productType === d.ARTIFACT.V ? "mesProductionTaskOrder" : k.value === b.TASK_LIST.V ? "mesAssembleProductionTaskOrder" : "mesAssembleNestingOrder";
      z.value.text = "正在加入打印队列：任务单";
      const s = await wt(e), x = n.detailData.productType === d.ARTIFACT.V ? { ...g.value, productionLineTypeEnum: (t = n.detailData.productionLine) == null ? void 0 : t.productionLineTypeEnum } : { ...g.value, type: k.value }, { header: B, footer: p, table: Y, qrCode: m } = await pt[e](x) || {};
      if (await te(500), z.value.text = "已全部加入打印队列", await te(500), !await dt({ printMode: ft.CUSTOM_QUEUE.V, header: B, footer: p, table: Y, qrCode: m, config: s })) throw new Error("导出失败");
      ee({ title: "打印成功", type: "success", duration: 2500 }), z.value.text = "已全部加入打印队列", await te(500);
    } catch (e) {
      throw ee({ title: "加入打印队列失败，请重试", type: "error", duration: 2500 }), new Error(e);
    } finally {
      z.value.close(), await ye({ ...g.value }), E("refresh");
    }
  }
  return (t, e) => {
    const s = Je, x = P("common-radio-button"), B = Xe, p = Ye, Y = Ze, m = P("common-button"), Z = P("print-table"), Me = et, r = tt, qe = at, se = P("common-table"), Fe = lt, Ue = P("common-drawer"), C = He("permission");
    return v(), y(Ue, { ref_key: "drawerRef", ref: ae, title: "生产任务单", visible: o(q), "onUpdate:visible": e[6] || (e[6] = (h) => Ge(q) ? q.value = h : null), direction: "rtl", "before-close": o(we), size: "87%" }, { titleAfter: i(() => [a(s, null, { default: i(() => {
      var h, l;
      return [c("项目：" + w(((h = n.detailData.project) == null ? void 0 : h.contractNo) + " " + ((l = n.detailData.project) == null ? void 0 : l.name)), 1)];
    }), _: 1 }), a(s, null, { default: i(() => {
      var h, l;
      return [c("产线：" + w((h = n.detailData.workshop) == null ? void 0 : h.name) + ">" + w((l = n.detailData.productionLine) == null ? void 0 : l.name), 1)];
    }), _: 1 }), a(s, null, { default: i(() => [c("总量：" + w($.value) + "/" + w(M.value ? o(ut)(M.value, "kg", "t", o(ct).COM_WT__T) : "-"), 1)]), _: 1 }), a(s, null, { default: i(() => [c("任务单号：" + w(n.detailData.scheduleOrder), 1)]), _: 1 })]), content: i(() => {
      var h;
      return [D("div", _t, [a(x, { modelValue: L.value, "onUpdate:modelValue": e[0] || (e[0] = (l) => L.value = l), options: oe.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, size: "default", showOptionAll: "", class: "filter-item", onChange: X }, null, 8, ["modelValue", "options"]), a(B, { modelValue: T.value, "onUpdate:modelValue": e[1] || (e[1] = (l) => T.value = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, clearable: "", onChange: X }, null, 8, ["modelValue"]), a(p, { modelValue: W.value, "onUpdate:modelValue": e[2] || (e[2] = (l) => W.value = l), placeholder: "输入构件编号", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: pe(I, ["enter"]) }, null, 8, ["modelValue"]), a(p, { modelValue: j.value, "onUpdate:modelValue": e[3] || (e[3] = (l) => j.value = l), placeholder: "输入构件规格", class: "filter-item", style: { width: "180px" }, size: "default", clearable: "", onKeyup: pe(I, ["enter"]) }, null, 8, ["modelValue"]), a(Y, { style: { "margin-right": "10px" }, modelValue: H.value, "onUpdate:modelValue": e[4] || (e[4] = (l) => H.value = l), label: "精确査询", onChange: I }, null, 8, ["modelValue"]), a(m, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: R(I, ["stop"]) }, { default: i(() => e[7] || (e[7] = [c("搜索")])), _: 1, __: [7] }), a(m, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: R(Ee, ["stop"]) }, { default: i(() => e[8] || (e[8] = [c(" 重置 ")])), _: 1, __: [8] }), S((v(), y(m, { class: "filter-item", disabled: G.value === false, size: "default", type: "danger", onClick: Ke }, { default: i(() => e[9] || (e[9] = [c(" 全部工单撤回 ")])), _: 1, __: [9] }, 8, ["disabled"])), [[C, o(_).allRevoke], [K, f.value === true]]), D("div", bt, [n.detailData.productType === o(d).ARTIFACT.V ? S((v(), y(Z, { key: 0, "api-key": "mesProductionTaskOrder", params: { ...g.value, productionLineTypeEnum: (h = n.detailData.productionLine) == null ? void 0 : h.productionLineTypeEnum }, onPrintSuccess: re, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])), [[C, o(_).print]]) : O("", true), S(a(Z, { "api-key": "mesAssembleProductionTaskOrder", params: { ...g.value, type: b.TASK_LIST.V }, onPrintSuccess: re, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"]), [[C, o(_).print], [K, n.detailData.productType === o(d).ASSEMBLE.V]]), S((v(), y(m, { size: "default", type: "warning", onClick: Ce, class: "filter-item" }, { default: i(() => e[10] || (e[10] = [c("取消编辑")])), _: 1, __: [10] })), [[C, o(_).cancelEdit], [K, f.value]]), S((v(), y(m, { size: "default", type: "primary", onClick: ke, class: "filter-item" }, { default: i(() => e[11] || (e[11] = [c("编辑")])), _: 1, __: [11] })), [[C, o(_).edit], [K, !L.value && f.value === false && n.detailData.productType === o(d).ARTIFACT.V]]), a(Me, { visible: V.value, "onUpdate:visible": e[5] || (e[5] = (l) => V.value = l), placement: "bottom", width: "180", trigger: "manual", onShow: ze, onHide: Be }, { reference: i(() => [S((v(), y(m, { loading: A.value, size: "default", type: "danger", class: "filter-item", disabled: !Q.value.length, onClick: R(xe, ["stop"]) }, { default: i(() => e[14] || (e[14] = [c(" 批量撤回 ")])), _: 1, __: [14] }, 8, ["loading", "disabled"])), [[C, o(_).batchRevoke], [K, f.value === true]])]), default: i(() => [e[15] || (e[15] = D("p", null, "是否确认批量撤回操作？", -1)), D("div", Tt, [a(m, { size: "default", link: "", onClick: R(Ne, ["stop"]), class: "filter-item" }, { default: i(() => e[12] || (e[12] = [c("取消")])), _: 1, __: [12] }), a(m, { size: "default", type: "danger", onClick: Ie, class: "filter-item" }, { default: i(() => e[13] || (e[13] = [c("确定")])), _: 1, __: [13] })])]), _: 1, __: [15] }, 8, ["visible"]), S((v(), y(m, { class: "filter-item", icon: "el-icon-printer", size: "default", type: "success", onClick: Oe }, { default: i(() => [c(" 打印" + w(n.detailData.productType === o(d).ARTIFACT.V || k.value === b.TASK_LIST.V ? "【任务清单】" : "【套料清单】"), 1)]), _: 1 })), [[C, o(_).print]])])]), D("div", null, [n.detailData.productType === o(d).ARTIFACT.V ? (v(), y(se, { key: 0, ref: "table", data: U.value, "empty-text": "暂无数据", "max-height": f.value === true ? o(J) - 50 : o(J), style: { width: "100%" }, onSelectionChange: Se }, { default: i(() => [f.value === true ? (v(), y(r, { key: 0, selectable: Pe, type: "selection", align: "center", width: "60" })) : O("", true), a(r, { label: "序号", type: "index", align: "center", width: "60" }), a(r, { "show-overflow-tooltip": true, label: "单体", key: "monomer.name", prop: "monomer.name", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "区域", key: "area.name", prop: "area.name", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "构件名称", key: "artifactName", prop: "artifactName", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "编号", key: "serialNumber", prop: "serialNumber", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "规格", key: "specification", prop: "specification", align: "center", "min-width": "110px" }), a(r, { "show-overflow-tooltip": true, label: "材质", key: "material", prop: "material", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "长度（mm）", key: "length", prop: "length", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "单净重（kg）", key: "netWeight", prop: "netWeight", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "单毛重（kg）", key: "grossWeight", prop: "grossWeight", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "总长度（mm）", key: "totalLength", prop: "totalLength", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "任务数", key: "quantity", prop: "quantity", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "计划完成日期", key: "complete", prop: "completeTime", align: "center" }, { default: i((l) => [D("span", null, w(l.row.completeTime ? o(fe)(l.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 }), f.value === true ? (v(), y(r, { key: 1, "show-overflow-tooltip": true, label: "操作", align: "center", width: "90px" }, { default: i((l) => [a(qe, { title: "是否确认撤回操作？", "confirm-button-text": "确认", "cancel-button-text": "取消", onConfirm: (ue) => Ae(l.row), onCancel: (ue) => Ve(l.row) }, { reference: i(() => [S((v(), y(m, { size: "default", type: "danger", disabled: l.row.boolCanRevoke === false || A.value, onClick: R((ue) => De(l.row), ["stop"]) }, { default: i(() => e[16] || (e[16] = [c(" 撤回 ")])), _: 2, __: [16] }, 1032, ["disabled", "onClick"])), [[C, o(_).revoke]])]), _: 2 }, 1032, ["onConfirm", "onCancel"])]), _: 1 })) : O("", true)]), _: 1 }, 8, ["data", "max-height"])) : O("", true), n.detailData.productType === o(d).ASSEMBLE.V ? (v(), y(se, { key: 1, ref: "table", data: U.value, "empty-text": "暂无数据", "max-height": o(J), style: { width: "100%" } }, { default: i(() => [a(r, { "show-overflow-tooltip": true, label: "属性", key: "taskType", prop: "taskType", align: "center" }, { default: i((l) => [a(s, { type: l.row.taskType === o(me).NESTING.V ? "success" : "warning" }, { default: i(() => [c(w(o(me).VL[l.row.taskType]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), a(r, { "show-overflow-tooltip": true, label: "编号", key: "serialNumber", prop: "serialNumber", align: "center", "min-width": "130px" }), a(r, { "show-overflow-tooltip": true, label: "规格", key: "specification", prop: "specification", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "长度（mm）", key: "length", prop: "length", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "数量", key: "quantity", prop: "quantity", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "单净重", key: "netWeight", prop: "netWeight", align: "center" }), a(r, { "show-overflow-tooltip": true, label: "完成日期", key: "complete", prop: "completeTime", align: "center" }, { default: i((l) => [D("span", null, w(l.row.completeTime ? o(fe)(l.row.completeTime, "{y}-{m}-{d}") : "-"), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])) : O("", true), a(Fe, { total: o(Te), "current-page": o(F).pageNumber, "page-size": o(F).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(_e), onCurrentChange: o(be) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])])];
    }), _: 1 }, 8, ["visible", "before-close"]);
  };
} }, Dt = ot(kt, [["__scopeId", "data-v-0965ccfc"]]);
export {
  Dt as default
};
