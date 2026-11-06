import { ref as s } from "vue";
import { computed as T } from "vue";
import { watch as re } from "vue";
import { provide as he } from "vue";
import { resolveComponent as z } from "vue";
import { resolveDirective as qe } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as P } from "vue";
import { withDirectives as K } from "vue";
import { vShow as Le } from "vue";
import { unref as t } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as Be } from "vue";
import { withCtx as i } from "vue";
import { createBlock as b } from "vue";
import { createTextVNode as c } from "vue";
import { createCommentVNode as v } from "vue";
import { toDisplayString as Me } from "vue";
import { ElMessageBox as Oe } from "element-plus";
import { ElMessage as $e } from "element-plus";
import { ElInput as Qe } from "element-plus";
import { ElDatePicker as Fe } from "element-plus";
import { ElPopconfirm as Ge } from "element-plus";
import { ElTag as Ke } from "element-plus";
import { ElTooltip as Xe } from "element-plus";
import { g as Ye, f as He, h as Je, l as We, i as Ze, j as ea, k as aa } from "../../../../../modules/artifact-tree-bcd3b733.js";
import { _ as ta } from "../../../../../modules/change-reason-select-73e53277.js";
import { _ as la, m as oa, K as na, tx as sa, B as ra, fa as X, i as Y, m9 as C, js as ia, T as h, q as ua, C as da, G as _, L as ie, E as ma } from "../../../../../shared/runtime.js";
import { a as pa } from "../../../../../modules/index-8356a01a.js";
import { _ as fa } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import ca from "../../../../contract/project-manage/module/enclosure-table/structure-table.vue.js";
import va from "./type-change-form.vue.js";
import ya from "./change-table.vue.js";
import ba from "./confirm-detail.vue.js";
import "./change-detail-table.vue.js";
import "../../../../../modules/use-production-team-d8043fd6.js";
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
const ga = { class: "filter-item" }, Va = { key: 0, class: "upload-tips" }, Ta = { class: "parent-div" }, Ia = { key: 1, class: "parent-div" }, wa = { key: 2, class: "parent-div", style: { height: "auto" } }, _a = { class: "parent-div" }, ka = { class: "parent-div" }, Ea = { class: "parent-div" }, Sa = { __name: "header-v2", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, emits: ["getAreaData", "getMonomerData"], setup(U, { expose: ue, emit: de }) {
  const { user: me } = oa(["user"]), pe = { artifactName: "", artifactSerialNumber: "", machinePartSerialNumber: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, projectId: { value: void 0, resetAble: false }, assembleSerialNumber: void 0, userName: void 0, dateTimeList: [] }, q = s(), g = s({}), H = s({}), I = s([]), L = s({}), J = s({}), N = s(false), R = s(false), B = s(false), w = s(), p = s(na.STEEL.V), k = s(), E = s(), M = s(false), W = s(sa.AREA.V), f = s(), D = s(false), y = s({}), O = s(false), S = s(false), $ = s(false);
  function fe() {
    D.value = true;
  }
  const ce = T(() => {
    let a = "";
    return f.value === 2 ? a = "清单变更导入" : a = w.value === 1 ? "清单增量导入" : "清单覆盖导入", a;
  }), ve = T(() => {
    let a = "";
    return f.value === 2 ? a = "清单变更导入" : a = w.value === 1 ? "清单增量导入" : "清单覆盖导入", a;
  }), ye = T(() => {
    let a = "";
    return f.value === 2 ? a = "primary" : a = w.value === 1 ? "primary" : "success", a;
  }), be = T(() => {
    let a = {};
    return f.value === 2 ? a = { areaId: l.query.areaId, importType: w.value, changeReasonId: k.value, remark: E.value, monomerId: l.query.monomerId, inventoryTypeEnum: p.value } : a = { areaId: l.query.areaId, importType: w.value, monomerId: l.query.monomerId, inventoryTypeEnum: p.value }, a;
  }), ge = T(() => {
    let a = false;
    return f.value === 2 ? a = !p.value || !E.value || !k.value : a = !p.value, a;
  }), Ve = s([new Date(2e3, 1, 1, 0, 0, 0), new Date(2e3, 2, 1, 23, 59, 59)]);
  function Te() {
    S.value = false, f.value && (f.value = void 0, k.value = void 0, E.value = void 0);
  }
  const { crud: l, query: u, CRUD: Z } = ra(pe), ee = de, Q = s([]), x = U, ae = T(() => {
    const a = [];
    for (const e in X.ENUM) me.value.mesInventoryProductEnum.includes(X.ENUM[e].V) && a.push(X.ENUM[e]);
    return a;
  });
  re(() => x.projectId, (a) => {
    a && (l.query.projectId = x.projectId, l.toQuery(), Se());
  }, { immediate: true, deep: true }), re(() => u.areaId, (a) => {
    a && (te(), j());
  }, { immediate: true, deep: true }), he("searchQuery", l.query);
  const Ie = T(() => {
    const a = { ...l.query };
    return delete a.machinePartSerialNumber, a;
  }), A = T(() => Y(y.value) ? y.value.inventoryReviewedEnum === C.FIXUP_RECORD.V || y.value.inventoryReviewedEnum === C.UNAUDITED.V : false);
  function we() {
    let a = [], e = {};
    if (q.value) {
      const m = q.value.getOption(u.monomerId) || {};
      Y(m) && (e = m, m.areaSimpleList && m.areaSimpleList.length > 0 && (a = m.areaSimpleList.filter((G) => G.productType === h.STRUCTURE.V)));
    }
    H.value = e, ee("getMonomerData", e), ee("getAreaData", a);
  }
  function F() {
    S.value = false, te(), j(), l.toQuery();
  }
  function _e(a) {
    const { name: e, label: m } = a;
    g.value = { id: e, name: m }, l.toQuery();
  }
  function ke(a) {
    I.value = a || [], I.value.length > 0 ? L.value = { id: I.value[0].id + "", name: I.value[0].name } : L.value = {};
  }
  async function te() {
  }
  async function Ee() {
    N.value = true;
    try {
      await ea({ areaId: l.query.areaId, monomerId: l.query.monomerId }), l.notify("操作成功", Z.NOTIFICATION_TYPE.SUCCESS), F(), N.value = false;
    } catch (a) {
      console.log("清空部件", a), N.value = false;
    }
  }
  async function Se() {
    try {
      const a = await ia(x.projectId);
      Y(a) && (J.value = { [h.STRUCTURE.V]: a.structureList || [] });
    } catch (a) {
      console.log("获取技术交底", a);
    }
  }
  function Ce(a, e) {
    e === 1 && (W.value = a, D.value = true), e === 2 && (f.value = e, S.value = true);
  }
  async function j() {
    y.value = {};
    try {
      const a = await Ye({ areaId: l.query.areaId });
      y.value = a || {};
    } catch (a) {
      console.log("获取异常构件", a);
    }
  }
  async function Ue() {
    R.value = true;
    try {
      const a = l.selections.map((e) => e.id);
      await l.crudApi.del({ artifactIds: a, monomerId: l.query.monomerId }), l.notify("删除成功", Z.NOTIFICATION_TYPE.SUCCESS), F(), R.value = false;
    } catch (a) {
      console.log("清空构件", a), R.value = false;
    }
  }
  async function Ne(a) {
    w.value = a, S.value = true, p.value = void 0;
  }
  async function Re() {
    $.value = true, p.value = void 0;
  }
  function le() {
    $.value = false;
  }
  function De() {
    Oe.confirm("是否确认要撤回该导入清单审核流程？", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
      const a = { checkStatus: C.REVOKED.V, id: y.value.id, paramList: [] };
      await aa(a), $e({ message: "撤回成功", type: "success" }), j(), l.refresh();
    }).catch((a) => {
      console.log(a);
    });
  }
  return ue({ inventoryReviewedData: y }), (a, e) => {
    const m = Qe, G = Fe, V = z("common-button"), xe = Ge, Ae = Ke, je = Xe, ze = z("common-drawer"), oe = z("common-select"), ne = z("common-dialog"), se = qe("permission");
    return d(), P("div", null, [K(r("div", null, [n(t(ua), { ref_key: "monomerSelectRef", ref: q, modelValue: t(u).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (o) => t(u).monomerId = o), productType: t(h).STRUCTURE.V, "project-id": x.projectId, "show-tips": I.value.length <= 0, class: "filter-item", onChange: we, onGetAreaInfo: ke }, null, 8, ["modelValue", "productType", "project-id", "show-tips"]), n(t(pa), { modelValue: t(u).areaId, "onUpdate:modelValue": e[1] || (e[1] = (o) => t(u).areaId = o), "area-info": I.value, "default-tab": L.value, style: Be(I.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), class: "filter-item", onTabClick: _e }, null, 8, ["modelValue", "area-info", "default-tab", "style"]), n(m, { modelValue: t(u).artifactName, "onUpdate:modelValue": e[2] || (e[2] = (o) => t(u).artifactName = o), class: "filter-item", clearable: "", placeholder: "输入构件名称搜索", size: "default", style: { width: "170px", "margin-left": "0" } }, null, 8, ["modelValue"]), n(m, { modelValue: t(u).artifactSerialNumber, "onUpdate:modelValue": e[3] || (e[3] = (o) => t(u).artifactSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入构件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(m, { modelValue: t(u).machinePartSerialNumber, "onUpdate:modelValue": e[4] || (e[4] = (o) => t(u).machinePartSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入零件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(m, { modelValue: t(u).assembleSerialNumber, "onUpdate:modelValue": e[5] || (e[5] = (o) => t(u).assembleSerialNumber = o), class: "filter-item", clearable: "", placeholder: "输入部件编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(m, { modelValue: t(u).userName, "onUpdate:modelValue": e[6] || (e[6] = (o) => t(u).userName = o), class: "filter-item", clearable: "", placeholder: "输入导入人名称搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(G, { modelValue: t(u).dateTimeList, "onUpdate:modelValue": e[7] || (e[7] = (o) => t(u).dateTimeList = o), "default-time": Ve.value, class: "filter-item date-item", "end-placeholder": "结束时间", "range-separator": ":", size: "default", "start-placeholder": "开始时间", style: { width: "240px" }, type: "daterange", "value-format": "x", onChange: t(l).toQuery }, null, 8, ["modelValue", "default-time", "onChange"]), n(t(da))], 512), [[Le, t(l).searchToggle]]), n(t(ma), { delText: "删除【未排产构件】" }, { optLeft: i(() => [g.value && g.value.id && t(_)(t(l).permission.import) ? (d(), b(V, { key: 0, disabled: A.value, class: "filter-item", size: "default", type: "primary", onClick: e[8] || (e[8] = (o) => Ne(1)) }, { default: i(() => e[20] || (e[20] = [c("清单增量导入 ")])), _: 1, __: [20] }, 8, ["disabled"])) : v("", true), g.value && g.value.id && t(_)(t(l).permission.download) ? (d(), b(ie, { key: 1, disabled: t(l).data.length === 0, fn: t(He), params: Ie.value, class: "filter-item" }, { default: i(() => e[21] || (e[21] = [c(" 零构件清单(按构件条件查询) ")])), _: 1, __: [21] }, 8, ["disabled", "fn", "params"])) : v("", true), K((d(), b(V, { class: "filter-item", icon: "el-icon-download", size: "default", type: "warning", onClick: Re }, { default: i(() => e[22] || (e[22] = [c("零构件清单模板 ")])), _: 1, __: [22] })), [[se, t(l).permission.templateDownload]]), g.value && g.value.id && t(_)(t(l).permission.del) ? (d(), b(xe, { key: 2, title: `确认清空【${g.value.name}】下的【零构件清单】么?`, onConfirm: Ee }, { reference: i(() => [n(V, { disabled: t(l).data.length === 0 || A.value, loading: N.value, class: "filter-item", size: "default", type: "danger" }, { default: i(() => e[23] || (e[23] = [c(" 一键清空(按区域) ")])), _: 1, __: [23] }, 8, ["disabled", "loading"])]), _: 1 }, 8, ["title"])) : v("", true), t(_)(t(l).permission.del) ? (d(), b(V, { key: 3, disabled: t(l).data.length === 0 || A.value || t(l).selections.length === 0, loading: R.value, class: "filter-item", size: "default", type: "danger", onClick: Ue }, { default: i(() => e[24] || (e[24] = [c(" 删除【未排产构件】 ")])), _: 1, __: [24] }, 8, ["disabled", "loading"])) : v("", true), n(V, { class: "filter-item", size: "default", type: "warning", onClick: fe }, { default: i(() => e[25] || (e[25] = [c("设计变更")])), _: 1, __: [25] })]), optRight: i(() => {
      var o;
      return [t(_)(t(l).permission.changeBtn) ? (d(), b(V, { key: 0, disabled: A.value, class: "filter-item", size: "default", type: "primary", onClick: e[9] || (e[9] = (Pe) => M.value = true) }, { default: i(() => e[26] || (e[26] = [c("变更操作 ")])), _: 1, __: [26] }, 8, ["disabled"])) : v("", true), y.value.inventoryReviewedEnum === t(C).FIXUP_RECORD.V ? (d(), b(V, { key: 1, class: "filter-item", size: "default", type: "danger", onClick: e[10] || (e[10] = (Pe) => O.value = true) }, { default: i(() => e[27] || (e[27] = [c("待确认信息 ")])), _: 1, __: [27] })) : v("", true), y.value.inventoryReviewedEnum === t(C).UNAUDITED.V ? (d(), b(V, { key: 2, disabled: !((o = y.value) != null && o.boolRevoke), class: "filter-item", size: "default", type: "primary", onClick: De }, { default: i(() => e[28] || (e[28] = [c("撤回审核 ")])), _: 1, __: [28] }, 8, ["disabled"])) : v("", true)];
    }), viewLeft: i(() => [n(je, { content: `${Q.value.join(",")}`, effect: "light", placement: "top" }, { default: i(() => [r("div", ga, [Q.value.length > 0 ? (d(), b(Ae, { key: 0, class: "filter-item", effect: "plain", type: "danger" }, { default: i(() => [c(" 本区域下存在" + Me(Q.value.length) + "条错误数据,鼠标悬停查看 ", 1)]), _: 1 })) : v("", true)])]), _: 1 }, 8, ["content"]), t(_)(t(l).permission.techDetail) ? (d(), b(V, { key: 0, size: "default", type: "primary", onClick: e[11] || (e[11] = (o) => B.value = true) }, { default: i(() => e[29] || (e[29] = [c(" 技术交底 ")])), _: 1, __: [29] })) : v("", true)]), _: 1 }), n(ze, { "before-close": () => {
      B.value = false;
    }, visible: B.value, "append-to-body": "", size: "80%", title: "技术交底(结构)" }, { content: i(() => [n(t(ca), { "is-show": true, "table-data": J.value[t(h).STRUCTURE.V], style: { "margin-top": "20px" } }, null, 8, ["table-data"])]), _: 1 }, 8, ["before-close", "visible"]), n(t(va), { modelValue: M.value, "onUpdate:modelValue": e[12] || (e[12] = (o) => M.value = o), onSuccess: Ce }, null, 8, ["modelValue"]), n(t(ya), { modelValue: D.value, "onUpdate:modelValue": e[13] || (e[13] = (o) => D.value = o), "global-project": U.globalProject, "project-id": U.projectId, type: W.value, onSuccess: t(l).toQuery }, null, 8, ["modelValue", "global-project", "project-id", "type", "onSuccess"]), n(t(ba), { modelValue: O.value, "onUpdate:modelValue": e[14] || (e[14] = (o) => O.value = o), currentArea: g.value, currentMonomer: H.value, currentRow: y.value, globalProject: U.globalProject, query: t(l).query, onSuccess: e[15] || (e[15] = () => {
      t(l).toQuery(), j();
    }) }, null, 8, ["modelValue", "currentArea", "currentMonomer", "currentRow", "globalProject", "query"]), n(ne, { "before-close": Te, "close-on-click-modal": false, title: ce.value, visible: S.value, "append-to-body": "", width: "400px" }, { default: i(() => [f.value === 2 ? (d(), P("div", Va, "*暂只支持构件名称/长度/数量(追加)/重量/面积的变更！")) : v("", true), r("div", Ta, [e[30] || (e[30] = r("span", { class: "parent-span" }, [r("span", { style: { color: "red" } }, "*"), r("span", { class: "title-span" }, "清单类型:")], -1)), n(oe, { modelValue: p.value, "onUpdate:modelValue": e[16] || (e[16] = (o) => p.value = o), options: ae.value, placeholder: "清单类型", size: "default", style: { flex: "1" }, type: "enum" }, null, 8, ["modelValue", "options"])]), f.value === 2 ? (d(), P("div", Ia, [e[31] || (e[31] = r("span", { class: "parent-span" }, [r("span", { style: { color: "red" } }, "*"), r("span", { class: "title-span" }, "原因类型:")], -1)), n(t(ta), { modelValue: k.value, "onUpdate:modelValue": e[17] || (e[17] = (o) => k.value = o), clearable: "", style: { flex: "1" } }, null, 8, ["modelValue"])])) : v("", true), f.value === 2 ? (d(), P("div", wa, [e[32] || (e[32] = r("span", { class: "parent-span" }, [r("span", { style: { color: "red" } }, "*"), r("span", { class: "title-span" }, "原因描述:")], -1)), n(m, { modelValue: E.value, "onUpdate:modelValue": e[18] || (e[18] = (o) => E.value = o), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 6 }, maxlength: 200, placeholder: "请填写原因描述", style: { flex: "1" }, type: "textarea" }, null, 8, ["modelValue"])])) : v("", true), r("div", _a, [e[33] || (e[33] = r("span", { class: "parent-span title-span" }, "上传清单:", -1)), n(t(fa), { "btn-name": ve.value, "btn-type": ye.value, data: be.value, disabled: ge.value, "upload-fun": f.value === 2 ? t(Je) : t(We), "btn-size": "default", style: { float: "left" }, onSuccess: F }, null, 8, ["btn-name", "btn-type", "data", "disabled", "upload-fun"])])]), _: 1 }, 8, ["title", "visible"]), n(ne, { "before-close": le, "close-on-click-modal": false, visible: $.value, "append-to-body": "", title: "零构件清单模板下载", width: "400px" }, { default: i(() => [r("div", ka, [e[34] || (e[34] = r("span", { class: "parent-span" }, [r("span", { style: { color: "red" } }, "*"), r("span", { class: "title-span" }, "清单类型:")], -1)), n(oe, { modelValue: p.value, "onUpdate:modelValue": e[19] || (e[19] = (o) => p.value = o), options: ae.value, placeholder: "清单类型", size: "default", style: { flex: "1" }, type: "enum" }, null, 8, ["modelValue", "options"])]), r("div", Ea, [e[36] || (e[36] = r("span", { class: "parent-span title-span" }, "下载模板:", -1)), K((d(), b(ie, { disabled: !p.value, fn: t(Ze), params: { mesInventoryProductEnum: p.value }, class: "filter-item", icon: "none", type: "primary", onDownloadSuccess: le }, { default: i(() => e[35] || (e[35] = [c(" 零构件清单模板 ")])), _: 1, __: [35] }, 8, ["disabled", "fn", "params"])), [[se, t(l).permission.templateDownload]])])]), _: 1 }, 8, ["visible"])]);
  };
} }, ot = la(Sa, [["__scopeId", "data-v-e42988b9"]]);
export {
  ot as default
};
