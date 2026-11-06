import { ref as r } from "vue";
import { computed as E } from "vue";
import { watch as W } from "vue";
import { provide as Me } from "vue";
import { resolveComponent as h } from "vue";
import { resolveDirective as Qe } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as x } from "vue";
import { withDirectives as L } from "vue";
import { vShow as Fe } from "vue";
import { unref as a } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as Ge } from "vue";
import { withCtx as u } from "vue";
import { createBlock as f } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as p } from "vue";
import { toDisplayString as He } from "vue";
import { ElMessage as de } from "element-plus";
import { ElMessageBox as Ke } from "element-plus";
import { ElInput as Xe } from "element-plus";
import { ElDatePicker as Ye } from "element-plus";
import { ElPopconfirm as Je } from "element-plus";
import { ElTag as We } from "element-plus";
import { ElTooltip as Ze } from "element-plus";
import { ElRadio as ea } from "element-plus";
import { ElRadioGroup as aa } from "element-plus";
import { g as ta, f as la, h as oa, l as na, i as sa, j as ra, k as ia } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ua } from "../../../../../modules/change-reason-select-73e53277.js";
import { _ as da, m as ma, tw as pa, K as fa, tx as va, B as ca, fa as Z, i as ee, m9 as A, js as ya, T as O, q as ba, ty as ga, C as Va, G as S, L as me, E as Ia } from "../../../../../shared/runtime.js";
import { a as Ta } from "../../../../../modules/index-8356a01a.js";
import wa from "./ExcelUploadBtnV2.vue.js";
import Ea from "../../../../contract/project-manage/module/enclosure-table/structure-table.vue.js";
import ka from "./type-change-form.vue.js";
import Sa from "./change-table.vue.js";
import _a from "./confirm-detail.vue.js";
import "./change-detail-table.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
import "../../../../../modules/ExcelUploadBtn-acccae97.js";
import "./change-detail-form.vue.js";
import "../../../../../modules/index-61ce89a1.js";
import "./change-confirm-form.vue.js";
import "./repeat-detail.vue.js";
import "../../../../../modules/use-drawing-8a7ba23b.js";
import "../../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../../modules/model-0ac957f7.js";
import "../../../../../modules/index-d6a37d29.js";
import "../../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../../modules/use-chart-59e4b63c.js";
import "../../../../../modules/index-18acf776.js";
import "./type-detail.vue.js";
import "./PL-detail.vue.js";
import "./auto-combination.vue.js";
import "../../../../../modules/assembly-template-config-631cc212.js";
import "./PL-config.vue.js";
const Ca = { class: "filter-item" }, Ua = { key: 0, class: "upload-tips" }, Na = { class: "parent-div" }, Da = { key: 1, class: "parent-div" }, Ra = { key: 2, class: "parent-div", style: { height: "auto" } }, ha = { key: 3, class: "parent-div" }, xa = { class: "parent-div" }, Aa = { class: "parent-div" }, Ba = { class: "parent-div" }, za = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["getAreaData", "getMonomerData", "batchRemove"], setup(ae, { expose: pe, emit: fe }) {
  const { user: ve } = ma(["user"]), ce = { artifactName: "", artifactSerialNumber: "", machinePartSerialNumber: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, projectId: { value: void 0, resetAble: false }, permissionCheck: pa.CHECK_PERMISSION.V, assembleSerialNumber: void 0, areaBatchId: void 0, userName: void 0, dateTimeList: [], boolImportDrawing: void 0 }, C = r(), k = r({}), V = r([]), $ = r({}), te = r({}), B = r(false), z = r(false), M = r(false), _ = r(), y = r(fa.STEEL.V), q = r("1"), T = r(""), w = r([]), U = r(), N = r(), Q = r(false), le = r(va.AREA.V), c = r(), F = r(false), b = r({}), G = r(false), D = r(false), H = r(false), ye = E(() => {
    let t = "";
    return c.value === 2 ? t = "清单变更导入" : t = _.value === 1 ? "清单增量导入" : "清单覆盖导入", t;
  }), be = E(() => {
    let t = "";
    return c.value === 2 ? t = "清单变更导入" : t = _.value === 1 ? "清单增量导入" : "清单覆盖导入", t;
  }), ge = E(() => {
    let t = "";
    return c.value === 2 ? t = "primary" : t = _.value === 1 ? "primary" : "success", t;
  }), Ve = E(() => {
    let t = {};
    return c.value === 2 ? t = { areaId: l.query.areaId, importType: _.value, changeReasonId: U.value, remark: N.value, monomerId: l.query.monomerId, inventoryTypeEnum: y.value, areaBatchName: T.value } : t = { areaId: l.query.areaId, importType: _.value, monomerId: l.query.monomerId, inventoryTypeEnum: y.value, areaBatchName: T.value }, t;
  }), Ie = E(() => {
    let t = false;
    return c.value === 2 && (t = !y.value || !N.value || !U.value), t;
  }), Te = r([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  function we() {
    D.value = false, c.value && (c.value = void 0, U.value = void 0, N.value = void 0);
  }
  const { crud: l, query: s, CRUD: oe } = ca(ce), K = fe, X = r([]), j = ae, ne = E(() => {
    const t = [];
    for (const e in Z.ENUM) ve.value.mesInventoryProductEnum.includes(Z.ENUM[e].V) && t.push(Z.ENUM[e]);
    return t;
  });
  W(() => j.projectId, (t) => {
    t && (l.query.projectId = j.projectId, V.value = [], l.query.monomerId = void 0, l.query.areaId = void 0, l.query.areaBatchId = void 0, l.toQuery(), De());
  }, { immediate: true, deep: true }), W(() => s.areaBatchId, () => {
    R();
  }), W([() => s.areaId, () => V.value], (t) => {
    var e;
    t && (Ue(), R(), V.value.length > 0 ? (w.value = (e = V.value.filter((m) => s.areaId === m.id)[0]) == null ? void 0 : e.planAreaBatchDTOS, $.value = { id: w.value ? w.value[0].id + "" : "", name: w.value ? w.value[0].name : "" }) : ($.value = {}, w.value = []));
  }, { immediate: true, deep: true }), Me("searchQuery", l.query);
  const Ee = E(() => {
    const t = { ...l.query };
    return delete t.machinePartSerialNumber, t;
  }), P = E(() => ee(b.value) ? b.value.inventoryReviewedEnum === A.FIXUP_RECORD.V || b.value.inventoryReviewedEnum === A.UNAUDITED.V : false);
  function ke() {
    let t = [], e = {};
    if (C.value) {
      const m = C.value.getOption(s.monomerId) || {};
      ee(m) && (e = m, m.areaSimpleList && m.areaSimpleList.length > 0 && (t = m.areaSimpleList.filter((g) => g.productType === O.STRUCTURE.V)));
    }
    K("getMonomerData", e), K("getAreaData", t);
  }
  function Y() {
    var t;
    if (!T.value || !y.value) {
      de.error("请填写必填项！");
      return;
    }
    D.value = false, R(), (t = C.value) == null || t.fetchData(), l.toQuery();
  }
  function Se() {
    var t;
    (t = C.value) == null || t.fetchData();
  }
  function _e(t) {
    const { name: e, label: m } = t;
    k.value = { id: e, name: m }, l.toQuery();
  }
  function Ce(t, e) {
    var m;
    V.value = t.filter((g) => g.itemizedType === 1) || [], s.areaId = (m = V.value[0]) == null ? void 0 : m.id;
  }
  async function Ue() {
  }
  async function Ne() {
    B.value = true;
    try {
      await ra({ areaId: l.query.areaId, monomerId: l.query.monomerId, areaBatchId: s.areaBatchId }), l.notify("操作成功", oe.NOTIFICATION_TYPE.SUCCESS), Y(), B.value = false;
    } catch (t) {
      console.log("清空部件", t), B.value = false;
    }
  }
  async function De() {
    try {
      const t = await ya(j.projectId);
      ee(t) && (te.value = { [O.STRUCTURE.V]: t.structureList || [] });
    } catch (t) {
      console.log("获取技术交底", t);
    }
  }
  function Re(t, e) {
    e === 1 && (le.value = t, F.value = true), e === 2 && (c.value = e, D.value = true);
  }
  async function R() {
    if (b.value = {}, !!l.query.areaId) try {
      const t = await ta({ areaBatchId: l.query.areaBatchId });
      b.value = t || {};
    } catch (t) {
      console.log("获取异常构件", t);
    }
  }
  async function he() {
    z.value = true;
    try {
      const t = l.selections.map((e) => e.id);
      await l.crudApi.del({ artifactIds: t, monomerId: l.query.monomerId }), l.notify("删除成功", oe.NOTIFICATION_TYPE.SUCCESS), Y(), z.value = false;
    } catch (t) {
      console.log("清空构件", t), z.value = false;
    }
  }
  async function xe(t) {
    _.value = t, D.value = true, y.value = void 0;
  }
  async function Ae() {
    H.value = true, y.value = void 0;
  }
  function se() {
    H.value = false;
  }
  function Be() {
    Ke.confirm("是否确认要撤回该导入清单审核流程？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      const t = { checkStatus: A.REVOKED.V, id: b.value.id, paramList: [] };
      await ia(t), de({ message: "撤回成功", type: "success" }), R(), l.refresh();
    }).catch((t) => {
      console.log(t);
    });
  }
  return pe({ inventoryReviewedData: b }), (t, e) => {
    const m = h("common-select"), g = Xe, ze = Ye, I = h("common-button"), qe = Je, je = We, Pe = Ze, Le = h("common-drawer"), Oe = h("common-select-v2"), re = ea, $e = aa, ie = h("common-dialog"), J = Qe("permission");
    return d(), x("div", null, [L(i("div", null, [n(a(ba), { ref_key: "monomerSelectRef", ref: C, modelValue: a(s).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (o) => a(s).monomerId = o), productType: a(O).STRUCTURE.V, "project-id": j.projectId, "show-tips": V.value.length <= 0, class: "filter-item", onChange: ke, onGetAreaInfo: Ce }, null, 8, ["modelValue", "productType", "project-id", "show-tips"]), n(m, { modelValue: a(s).areaId, "onUpdate:modelValue": e[1] || (e[1] = (o) => a(s).areaId = o), dataStructure: { key: "id", label: "name", value: "id" }, options: V.value, class: "filter-item", placeholder: "请选择区域", style: { width: "200px", "margin-left": "3px" }, type: "other", onChange: a(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(a(Ta), { modelValue: a(s).areaBatchId, "onUpdate:modelValue": e[2] || (e[2] = (o) => a(s).areaBatchId = o), "area-info": w.value, "default-tab": $.value, style: Ge(V.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: _e }, null, 8, ["modelValue", "area-info", "default-tab", "style"]), n(g, { modelValue: a(s).artifactName, "onUpdate:modelValue": e[3] || (e[3] = (o) => a(s).artifactName = o), class: "filter-item", clearable: "", placeholder: "输入构件名称搜索", size: "default", style: { width: "170px", "margin-left": "0" } }, null, 8, ["modelValue"]), n(g, { modelValue: a(s).artifactSerialNumber, "onUpdate:modelValue": e[4] || (e[4] = (o) => a(s).artifactSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入构件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(g, { modelValue: a(s).machinePartSerialNumber, "onUpdate:modelValue": e[5] || (e[5] = (o) => a(s).machinePartSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入零件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(g, { modelValue: a(s).assembleSerialNumber, "onUpdate:modelValue": e[6] || (e[6] = (o) => a(s).assembleSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入部件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(g, { modelValue: a(s).userName, "onUpdate:modelValue": e[7] || (e[7] = (o) => a(s).userName = o), class: "filter-item", clearable: "", placeholder: "输入导入人名称搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(ze, { modelValue: a(s).dateTimeList, "onUpdate:modelValue": e[8] || (e[8] = (o) => a(s).dateTimeList = o), "default-time": Te.value, class: "filter-item date-item", "end-placeholder": "结束时间", "range-separator": ":", size: "default", "start-placeholder": "开始时间", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: a(l).toQuery }, null, 8, ["modelValue", "default-time", "onChange"]), n(m, { modelValue: a(s).boolImportDrawing, "onUpdate:modelValue": e[9] || (e[9] = (o) => a(s).boolImportDrawing = o), options: a(ga).ENUM, class: "filter-item", placeholder: "全部", size: "default", type: "enum", clearable: "", onChange: a(l).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(a(Va))], 512), [[Fe, a(l).searchToggle]]), n(a(Ia), { delText: "删除【未排产构件】" }, { optLeft: u(() => [a(S)(a(l).permission.import) ? (d(), f(I, { key: 0, disabled: !a(S)(a(l).permission.import), class: "filter-item", size: "mini", type: "primary", onClick: e[10] || (e[10] = (o) => xe(1)) }, { default: u(() => e[27] || (e[27] = [v(" 清单增量导入 ")])), _: 1, __: [27] }, 8, ["disabled"])) : p("", true), k.value && k.value.id && a(S)(a(l).permission.download) ? (d(), f(me, { key: 1, disabled: a(l).data.length === 0, fn: a(la), params: Ee.value, class: "filter-item" }, { default: u(() => e[28] || (e[28] = [v(" 零构件清单(按构件条件查询) ")])), _: 1, __: [28] }, 8, ["disabled", "fn", "params"])) : p("", true), L((d(), f(I, { class: "filter-item", icon: "el-icon-download", size: "default", type: "warning", onClick: Ae }, { default: u(() => e[29] || (e[29] = [v("零构件清单模板 ")])), _: 1, __: [29] })), [[J, a(l).permission.templateDownload]]), k.value && k.value.id && a(S)(a(l).permission.del) ? (d(), f(qe, { key: 2, title: `确认清空【${k.value.name}】下的【零构件清单】么?`, onConfirm: Ne }, { reference: u(() => [n(I, { disabled: a(l).data.length === 0 || P.value || !a(s).areaBatchId, loading: B.value, class: "filter-item", size: "default", type: "danger" }, { default: u(() => e[30] || (e[30] = [v(" 一键清空(按批次) ")])), _: 1, __: [30] }, 8, ["disabled", "loading"])]), _: 1 }, 8, ["title"])) : p("", true), a(S)(a(l).permission.del) ? (d(), f(I, { key: 3, disabled: a(l).data.length === 0 || P.value || a(l).selections.length === 0, loading: z.value, class: "filter-item", size: "default", type: "danger", onClick: he }, { default: u(() => e[31] || (e[31] = [v(" 删除【未排产构件】 ")])), _: 1, __: [31] }, 8, ["disabled", "loading"])) : p("", true)]), optRight: u(() => {
      var o;
      return [a(S)(a(l).permission.changeBtn) ? (d(), f(I, { key: 0, disabled: P.value, class: "filter-item", size: "default", type: "primary", onClick: e[11] || (e[11] = (ue) => Q.value = true) }, { default: u(() => e[32] || (e[32] = [v("变更操作 ")])), _: 1, __: [32] }, 8, ["disabled"])) : p("", true), b.value.inventoryReviewedEnum === a(A).FIXUP_RECORD.V ? (d(), f(I, { key: 1, class: "filter-item", size: "default", type: "danger", onClick: e[12] || (e[12] = (ue) => G.value = true) }, { default: u(() => e[33] || (e[33] = [v("待确认信息 ")])), _: 1, __: [33] })) : p("", true), b.value.inventoryReviewedEnum === a(A).UNAUDITED.V ? (d(), f(I, { key: 2, disabled: !((o = b.value) != null && o.boolRevoke), class: "filter-item", size: "default", type: "primary", onClick: Be }, { default: u(() => e[34] || (e[34] = [v("撤回审核 ")])), _: 1, __: [34] }, 8, ["disabled"])) : p("", true), L((d(), f(I, { disabled: !a(l).selections.length || P.value, class: "filter-item", size: "default", type: "danger", onClick: e[13] || (e[13] = (ue) => K("batchRemove")) }, { default: u(() => e[35] || (e[35] = [v("批量删除 ")])), _: 1, __: [35] }, 8, ["disabled"])), [[J, a(l).permission.changeBtn]])];
    }), viewLeft: u(() => [n(Pe, { content: `${X.value.join(",")}`, effect: "light", placement: "top" }, { default: u(() => [i("div", Ca, [X.value.length > 0 ? (d(), f(je, { key: 0, class: "filter-item", effect: "plain", type: "danger" }, { default: u(() => [v(" 本区域下存在" + He(X.value.length) + "条错误数据,鼠标悬停查看 ", 1)]), _: 1 })) : p("", true)])]), _: 1 }, 8, ["content"]), a(S)(a(l).permission.techDetail) ? (d(), f(I, { key: 0, size: "default", type: "primary", onClick: e[14] || (e[14] = (o) => M.value = true) }, { default: u(() => e[36] || (e[36] = [v(" 技术交底 ")])), _: 1, __: [36] })) : p("", true)]), _: 1 }), n(Le, { "before-close": () => {
      M.value = false;
    }, visible: M.value, "append-to-body": "", size: "80%", title: "技术交底(结构)" }, { content: u(() => [n(a(Ea), { "is-show": true, "table-data": te.value[a(O).STRUCTURE.V], style: { "margin-top": "20px" } }, null, 8, ["table-data"])]), _: 1 }, 8, ["before-close", "visible"]), n(a(ka), { modelValue: Q.value, "onUpdate:modelValue": e[15] || (e[15] = (o) => Q.value = o), onSuccess: Re, currentArea: k.value, onEditAreaBatchSucccess: Se }, null, 8, ["modelValue", "currentArea"]), n(a(Sa), { modelValue: F.value, "onUpdate:modelValue": e[16] || (e[16] = (o) => F.value = o), type: le.value, onSuccess: a(l).toQuery }, null, 8, ["modelValue", "type", "onSuccess"]), n(a(_a), { modelValue: G.value, "onUpdate:modelValue": e[17] || (e[17] = (o) => G.value = o), currentRow: b.value, globalProject: ae.globalProject, query: a(l).query, onSuccess: e[18] || (e[18] = () => {
      a(l).toQuery(), R();
    }) }, null, 8, ["modelValue", "currentRow", "globalProject", "query"]), n(ie, { "before-close": we, "close-on-click-modal": false, title: ye.value, visible: D.value, "append-to-body": "", width: "400px", onOpen: t.getBatchNumber }, { default: u(() => [c.value === 2 ? (d(), x("div", Ua, "*暂只支持构件名称/长度/数量(追加)/重量/面积的变更！")) : p("", true), i("div", Na, [e[37] || (e[37] = i("span", { class: "parent-span" }, [i("span", { style: { color: "red" } }, "*"), i("span", { class: "title-span" }, "清单类型:")], -1)), n(Oe, { modelValue: y.value, "onUpdate:modelValue": e[19] || (e[19] = (o) => y.value = o), options: ne.value, placeholder: "清单类型", size: "default", style: { flex: "1" }, type: "enum" }, null, 8, ["modelValue", "options"])]), c.value === 2 ? (d(), x("div", Da, [e[38] || (e[38] = i("span", { class: "parent-span" }, [i("span", { style: { color: "red" } }, "*"), i("span", { class: "title-span" }, "原因类型:")], -1)), n(a(ua), { modelValue: U.value, "onUpdate:modelValue": e[20] || (e[20] = (o) => U.value = o), clearable: "", style: { flex: "1" } }, null, 8, ["modelValue"])])) : p("", true), c.value === 2 ? (d(), x("div", Ra, [e[39] || (e[39] = i("span", { class: "parent-span" }, [i("span", { style: { color: "red" } }, "*"), i("span", { class: "title-span" }, "原因描述:")], -1)), n(g, { modelValue: N.value, "onUpdate:modelValue": e[21] || (e[21] = (o) => N.value = o), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 6 }, maxlength: 200, placeholder: "请填写原因描述", style: { flex: "1" }, type: "textarea" }, null, 8, ["modelValue"])])) : p("", true), c.value !== 2 ? (d(), x("div", ha, [e[42] || (e[42] = i("span", { class: "parent-span" }, [i("span", { style: { color: "red" } }, "*"), i("span", { class: "title-span" }, "批次号:")], -1)), n($e, { modelValue: q.value, "onUpdate:modelValue": e[22] || (e[22] = (o) => q.value = o), onChange: e[23] || (e[23] = (o) => T.value = "") }, { default: u(() => [n(re, { label: "1" }, { default: u(() => e[40] || (e[40] = [v("手动输入")])), _: 1, __: [40] }), n(re, { label: "2" }, { default: u(() => e[41] || (e[41] = [v("选择已有批次")])), _: 1, __: [41] })]), _: 1 }, 8, ["modelValue"]), q.value === "1" ? (d(), f(g, { key: 0, modelValue: T.value, "onUpdate:modelValue": e[24] || (e[24] = (o) => T.value = o), placeholder: "请输入批次号", style: { width: "100%" } }, null, 8, ["modelValue"])) : p("", true), q.value === "2" ? (d(), f(m, { key: 1, modelValue: T.value, "onUpdate:modelValue": e[25] || (e[25] = (o) => T.value = o), dataStructure: { key: "name", label: "name", value: "name" }, options: w.value, placeholder: "请选择批次号", size: "small", style: { width: "100%" }, type: "other" }, null, 8, ["modelValue", "options"])) : p("", true)])) : p("", true), i("div", xa, [e[43] || (e[43] = i("span", { class: "parent-span title-span" }, "数据导入:", -1)), n(wa, { "btn-name": be.value, "btn-type": ge.value, data: Ve.value, disabled: Ie.value, "upload-fun": c.value === 2 ? a(oa) : a(na), "btn-size": "default", style: { flex: "1" }, onSuccess: Y }, null, 8, ["btn-name", "btn-type", "data", "disabled", "upload-fun"])])]), _: 1 }, 8, ["title", "visible", "onOpen"]), n(ie, { "before-close": se, "close-on-click-modal": false, visible: H.value, "append-to-body": "", title: "零构件清单模板下载", width: "400px" }, { default: u(() => [i("div", Aa, [e[44] || (e[44] = i("span", { class: "parent-span" }, [i("span", { style: { color: "red" } }, "*"), i("span", { class: "title-span" }, "清单类型:")], -1)), n(m, { modelValue: y.value, "onUpdate:modelValue": e[26] || (e[26] = (o) => y.value = o), options: ne.value, placeholder: "清单类型", size: "default", style: { flex: "1" }, type: "enum" }, null, 8, ["modelValue", "options"])]), i("div", Ba, [e[46] || (e[46] = i("span", { class: "parent-span title-span" }, "下载模板:", -1)), L((d(), f(me, { disabled: !y.value, fn: a(sa), params: { mesInventoryProductEnum: y.value }, class: "filter-item", icon: "none", type: "primary", onDownloadSuccess: se }, { default: u(() => e[45] || (e[45] = [v(" 零构件清单模板 ")])), _: 1, __: [45] }, 8, ["disabled", "fn", "params"])), [[J, a(l).permission.templateDownload]])])]), _: 1 }, 8, ["visible"])]);
  };
} }, ct = da(za, [["__scopeId", "data-v-f679f2eb"]]);
export {
  ct as default
};
