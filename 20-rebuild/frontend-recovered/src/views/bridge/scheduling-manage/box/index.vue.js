import { provide as E } from "vue";
import { ref as m } from "vue";
import { computed as Ve } from "vue";
import { resolveComponent as ee } from "vue";
import { resolveDirective as qe } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as De } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as b } from "vue";
import { vShow as te } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as w } from "vue";
import { createBlock as f } from "vue";
import { toDisplayString as B } from "vue";
import { createCommentVNode as T } from "vue";
import ae from "moment";
import { isRef as Le } from "vue";
import { ElMessage as Re } from "element-plus";
import { ElMessageBox as Ne } from "element-plus";
import { ElTag as Ee } from "element-plus";
import { ElBadge as Be } from "element-plus";
import { ElTableColumn as Oe } from "element-plus";
import { ElInputNumber as Ue } from "element-plus";
import { ElCascader as Pe } from "element-plus";
import { ElDatePicker as Qe } from "element-plus";
import { vLoading as Fe } from "element-plus";
import { c as Me, g as Ae, a as ze } from "../../../../modules/box-3fab54f9.js";
import { _ as He, F as je, x as We, o as Ge, P as Ke, aw as Xe, O as Ye, c9 as Je } from "../../../../shared/runtime.js";
import { B as O } from "../../../../modules/bridge-86f96a4f.js";
import { u as Ze } from "../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import $e from "./module/header.vue.js";
import et from "./module/preview.vue.js";
import tt from "./module/preview-summary-detail.vue.js";
import at from "./module/project-to-area-tree.vue.js";
import { _ as ot } from "../../../../modules/index-6a17f241.js";
import { u as rt } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as nt } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "../../../../modules/use-get-box-type-list-1288a5cc.js";
import "../../../../modules/index-2d037787.js";
import "./module/edit-form.vue.js";
import "./module/batch-edit-form.vue.js";
import "./module/del-form.vue.js";
import "./module/batch-del-form.vue.js";
import "./module/element-scheduling-form.vue.js";
import "../../../../modules/common-8949b382.js";
import "./module/handle-surplus-element-dialog.vue.js";
import "../common/project-header-time.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const it = { class: "app-container wrap" }, lt = { class: "wrap-left" }, st = { class: "wrap-right" }, ut = { class: "head-container" }, dt = { __name: "index", setup(pt) {
  const I = je.BOX.V;
  E("productType", I);
  const x = m(), U = m(), S = m([]), oe = m([]), V = m({}), y = m(), P = m([]), C = m(false), q = m(false), { showDrawing: D, drawingRow: h, drawingPreview: re } = rt({ pidField: "id", productTypeField: "BOX" }), ne = { add: false, edit: false, del: false, download: false }, Q = m(), { crud: l, columns: v, CRUD: F } = We({ title: "分段排产", sort: [], permission: { get: O.get }, optShow: { ...ne }, crudApi: { ...Me }, queryOnPresenterCreated: false, requiredQuery: ["areaIdList", "boxClassId"] }, Q), { maxHeight: ie, heightStyle: le } = Ge({ paginate: true }), L = m([]), k = m({}), se = Ve(() => ({ productType: I, boxClassId: l.query.boxClassId })), { groupsTree: ue, groupsObj: de } = Ze({ queryParams: se, factoryIds: S });
  E("areaIdObj", V), E("curFactoryIds", S);
  function pe(a, e, n, u) {
    if (!e.groupsId || e.groupsId === "同上") {
      const i = u.panel.menuList[0];
      R(i, i.nodes[0]);
    }
  }
  function R(a, e) {
    e != null && e.isLeaf || (a.panel.expandNode(e, true), e.children[0].isLeaf || R(a, e.children[0]));
  }
  function ce(a, e, n, u) {
    const i = u.panel.menuList[0], o = i.panel.expandingNode;
    o.children[0].isLeaf || R(i, o.children[0]);
  }
  const me = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Je, message: "数量必须大于0", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, ge = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: fe, cleanUpData: he, wrongCellMask: ye } = Xe({ rules: me, ditto: ge });
  F.HOOK.beforeToQuery = () => {
    ve(), N();
  }, F.HOOK.handleRefresh = (a, e) => {
    e.data.content = e.data.content.map((n, u) => {
      var i, o;
      return n.needSchedulingQuantity = n.unSchedulingQuantity, n.factoryId = (o = V.value[(i = n.area) == null ? void 0 : i.id]) == null ? void 0 : o.factoryId, u > 0 && (n.askCompleteTime = "同上", n.groupsId = "同上"), n.rowKey = u + "" + Math.random(), n;
    });
  };
  async function ve() {
    try {
      k.value = await Ae(l.query) || {};
    } catch (a) {
      console.log(a, "获取汇总信息");
    }
  }
  function _e(a, e, n) {
    n !== 0 && !a && (e.groupsId = "同上");
  }
  function be(a, e, n) {
    n !== 0 && !a && (e.askCompleteTime = "同上");
  }
  function M(a = false) {
    var e;
    a && ((e = U.value) == null || e.refreshTypeList()), N(), l.toQuery();
  }
  const we = Ye(function(a = []) {
    x.value = 0, k.value = {};
    const e = [], n = {}, u = [], i = [];
    y.value = void 0;
    for (let o = 0; o < a.length; o++) e.push(a[o].id), n[a[o].id] = a[o], u.push(a[o].factoryId), i.push(a[o].workshopId), y.value = y.value ? Math.min(a[o].endDate, y.value) : a[o].endDate;
    l.query.areaIdList = e, l.query.boxClassId = void 0, V.value = n, S.value = u, oe.value = i, N(), l.toQuery();
  }, 500);
  async function Ie() {
    var u;
    if (!((u = l.selections) != null && u.length)) {
      Re.warning("请至少选择一条数据");
      return;
    }
    const a = l.selections.map((i) => i), { validResult: e, dealList: n } = fe(a);
    if (e) {
      he(n);
      let i = false;
      if (P.value = n.map((o, A) => (o.askCompleteTime > y.value && (i = true), { ...o, ...de.value[o.groupsId] })), i) {
        try {
          await Ne.confirm("排产计划大于排期计划，是否确定？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), C.value = true;
        } catch (o) {
          console.log(o, "取消");
        }
        return;
      }
    } else return e;
    C.value = true;
  }
  async function N() {
    try {
      const a = await ze({ areaIdList: l.query.areaIdList });
      x.value = a;
    } catch (a) {
      console.log("获取构件排产记录气泡条数失败", a);
    }
  }
  function xe() {
    q.value = true;
  }
  return (a, e) => {
    var H, j, W, G, K, X, Y, J, Z, $;
    const n = Ee, u = ee("common-button"), i = Be, o = Oe, A = Ue, Ce = Pe, ke = Qe, Te = ee("common-table"), z = qe("permission"), Se = Fe;
    return g(), De("div", it, [_("div", lt, [s(t(at), { heightStyle: t(le), onAreaClick: t(we) }, null, 8, ["heightStyle", "onAreaClick"])]), _("div", st, [b(s(n, { type: "info", size: "large" }, { default: p(() => e[5] || (e[5] = [w(" * 请先选择区域，进行分段区域排产 ")])), _: 1, __: [5] }, 512), [[te, !((j = (H = t(l).query) == null ? void 0 : H.areaIdList) != null && j.length)]]), b(_("div", null, [_("div", ut, [s(t($e), { ref_key: "mHeaderRef", ref: U }, { optLeft: p(() => [b((g(), f(u, { type: "success", size: "default", onClick: Ie }, { default: p(() => e[6] || (e[6] = [w("预览并保存")])), _: 1, __: [6] })), [[z, t(O).save]])]), viewLeft: p(() => [s(n, { size: "large", effect: "plain", style: { "margin-right": "5px" } }, { default: p(() => [w(" 数量(件)：" + B(k.value.quantity || 0), 1)]), _: 1 }), s(n, { size: "large", effect: "plain", style: { "margin-right": "10px" } }, { default: p(() => {
      var r;
      return [w(" 重量(kg)：" + B(((r = k.value.totalNetWeight) == null ? void 0 : r.toFixed(2)) || 0), 1)];
    }), _: 1 }), s(i, { value: x.value, max: 99, hidden: x.value < 1, style: { "margin-right": "20px" } }, { default: p(() => [b((g(), f(u, { type: "primary", size: "default", onClick: xe }, { default: p(() => e[7] || (e[7] = [w(" 分段排产记录 ")])), _: 1, __: [7] })), [[z, t(O).recordGet]])]), _: 1 }, 8, ["value", "hidden"])]), _: 1 }, 512)]), b((g(), f(Te, { ref_key: "tableRef", ref: Q, data: t(l).data, "empty-text": t(l).emptyText, "max-height": t(ie) - 110, "row-key": "rowKey", "cell-class-name": t(ye), style: { width: "100%" }, onSelectionChange: t(l).selectionChangeHandler }, { default: p(() => [s(o, { type: "selection", width: "55", align: "center" }), s(o, { label: "序号", type: "index", align: "center", width: "60" }), s(t(ot), { productType: t(I), snClickable: "", onDrawingPreview: t(re), columns: t(v) }, null, 8, ["productType", "onDrawingPreview", "columns"]), t(v).visible("netWeight") ? (g(), f(o, { key: 0, "show-overflow-tooltip": true, prop: "netWeight", label: "单净重(kg)", "min-width": "80px", align: "center" }, { default: p(({ row: r }) => [_("span", null, B(r.netWeight), 1)]), _: 1 })) : T("", true), t(v).visible("needSchedulingQuantity") ? (g(), f(o, { key: 1, "show-overflow-tooltip": true, prop: "needSchedulingQuantity", label: "数量", "min-width": "120px", align: "center" }, { default: p(({ row: { sourceRow: r } }) => [s(A, { modelValue: r.needSchedulingQuantity, "onUpdate:modelValue": (c) => r.needSchedulingQuantity = c, step: 1, min: 1, max: r.unSchedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 })) : T("", true), t(v).visible("groupsId") ? (g(), f(o, { key: 2, "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: p(({ row: { sourceRow: r }, $index: c }) => [s(Ce, { ref: (d) => L.value[c] = d, modelValue: r.groupsId, "onUpdate:modelValue": (d) => r.groupsId = d, options: t(ue), props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, filterable: "", clearable: "", placeholder: c === 0 ? "请选择生产组" : "同上", onExpandChange: (d) => ce(d, r, c, L.value[c]), onFocus: (d) => pe(d, r, c, L.value[c]), onChange: (d) => _e(d, r, c) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onExpandChange", "onFocus", "onChange"])]), _: 1 })) : T("", true), t(v).visible("askCompleteTime") ? (g(), f(o, { key: 3, prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: p(({ row: { sourceRow: r }, $index: c }) => [s(ke, { modelValue: r.askCompleteTime, "onUpdate:modelValue": (d) => r.askCompleteTime = d, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (d) => t(ae)(d).valueOf() < t(ae)().subtract(1, "days").valueOf(), placeholder: c === 0 ? "需求完成日期" : "同上", onChange: (d) => be(d, r, c) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"])]), _: 1 })) : T("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name", "onSelectionChange"])), [[Se, t(l).loading]]), s(t(Ke))], 512), [[te, (G = (W = t(l).query) == null ? void 0 : W.areaIdList) == null ? void 0 : G.length]]), s(t(nt), { visible: t(D), "onUpdate:visible": e[0] || (e[0] = (r) => Le(D) ? D.value = r : null), "bool-bim": (K = t(h)) == null ? void 0 : K.boolBim, drawingSN: (X = t(h)) == null ? void 0 : X.drawingSN, "monomer-id": (Y = t(h)) == null ? void 0 : Y.monomerId, "area-id": t(l).query.areaId, "serial-number": (J = t(h)) == null ? void 0 : J.serialNumber, productId: (Z = t(h)) == null ? void 0 : Z.productId, productType: ($ = t(h)) == null ? void 0 : $.productType }, null, 8, ["visible", "bool-bim", "drawingSN", "monomer-id", "area-id", "serial-number", "productId", "productType"]), s(t(et), { visible: C.value, "onUpdate:visible": e[1] || (e[1] = (r) => C.value = r), productType: t(I), list: P.value, onSuccess: e[2] || (e[2] = (r) => M(true)) }, null, 8, ["visible", "productType", "list"]), s(t(tt), { visible: q.value, "onUpdate:visible": e[3] || (e[3] = (r) => q.value = r), "other-query": { areaIdList: t(l).query.areaIdList }, onRefresh: e[4] || (e[4] = (r) => M(true)) }, null, 8, ["visible", "other-query"])])]);
  };
} }, At = He(dt, [["__scopeId", "data-v-d6c9b631"]]);
export {
  At as default
};
