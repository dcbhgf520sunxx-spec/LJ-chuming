import { provide as M } from "vue";
import { ref as c } from "vue";
import { computed as Ae } from "vue";
import { resolveComponent as ce } from "vue";
import { resolveDirective as Fe } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as Qe } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as m } from "vue";
import { unref as t } from "vue";
import { withDirectives as q } from "vue";
import { vShow as fe } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as I } from "vue";
import { createBlock as y } from "vue";
import { createCommentVNode as h } from "vue";
import { toDisplayString as k } from "vue";
import H from "moment";
import { isRef as Be } from "vue";
import { ElMessage as ze } from "element-plus";
import { ElMessageBox as Me } from "element-plus";
import { ElTag as He } from "element-plus";
import { ElBadge as Ge } from "element-plus";
import { ElTableColumn as Ke } from "element-plus";
import { ElInputNumber as $e } from "element-plus";
import { ElCascader as Ye } from "element-plus";
import { ElDatePicker as Je } from "element-plus";
import { vLoading as Xe } from "element-plus";
import { c as Ze, a as et, b as tt, d as at } from "../../../../modules/artifact-f1b0ca44.js";
import { d as ot } from "../../../../modules/common-a5dc7899.js";
import { _ as rt, a3 as lt, x as it, qs as S, o as nt, G as ge, L as st, P as ut, aw as dt, O as pt, c9 as mt } from "../../../../shared/runtime.js";
import { u as ct } from "../../../../modules/use-scheduling-line-f234c58c.js";
import ft from "./module/header.vue.js";
import gt from "./module/preview.vue.js";
import yt from "./module/task-import-dialog.vue.js";
import ht from "./module/preview-summary-detail.vue.js";
import vt from "./module/project-to-area-tree.vue.js";
import _t from "./module/work-info.vue.js";
import { _ as bt } from "../../../../modules/index-490fd9d7.js";
import { u as It } from "../../../../modules/use-drawing-8a7ba23b.js";
import { b as wt } from "../../../../modules/bim-preview-drawer-7ca7893b.js";
import "./module/edit-form.vue.js";
import "./module/batch-edit-form.vue.js";
import "./module/del-form.vue.js";
import "./module/batch-del-form.vue.js";
import "./module/assemble-scheduling-form.vue.js";
import "./module/handle-surplus-assemble-dialog.vue.js";
import "../common/group-header.vue.js";
import "../common/project-header-time.vue.js";
import "../../../../modules/bim-model-view-dbf77a11.js";
import "../../../../modules/bimfaceAPI-c2661893.js";
import "../../../../modules/model-0ac957f7.js";
import "../../../../modules/index-d6a37d29.js";
import "../../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../../modules/use-chart-59e4b63c.js";
import "../../../../modules/index-18acf776.js";
const kt = { class: "app-container wrap" }, xt = { class: "wrap-left" }, Tt = { class: "wrap-right" }, Ct = { class: "head-container" }, qt = { __name: "index", setup(St) {
  const x = lt.ARTIFACT.V;
  M("productType", x);
  const L = c(), O = c([]), G = c([]), R = c({}), K = c([]), T = c(), $ = c([]), V = c(false), U = c(false), N = c(void 0), j = c(false), { showDrawing: E, drawingRow: w, drawingPreview: ye } = It({ pidField: "productId", productTypeField: "ARTIFACT" }), he = { add: false, edit: false, del: false, download: false }, D = c(), Y = c(), { crud: i, columns: v, CRUD: J } = it({ title: "构件排产", sort: [], permission: { get: S.get }, optShow: { ...he }, crudApi: { ...Ze }, queryOnPresenterCreated: false, requiredQuery: ["areaIdList"] }, Y), { maxHeight: ve, heightStyle: _e } = nt({ paginate: true });
  i.page.size = 50;
  const W = c([]), A = c(false), C = c({}), X = Ae(() => ({ productType: x, structureClassId: i.query.structureClassId, artName: i.query.artName, mesProductEnum: i.query.mesProductEnum })), { groupsTree: P, groupsObj: be } = ct({ queryParams: X, factoryIds: O });
  M("areaIdObj", R), M("curFactoryIds", O);
  function Ie(a, e, n, s) {
    var l;
    if (!e.groupsId || e.groupsId === "同上") {
      const r = (l = s == null ? void 0 : s.panel) == null ? void 0 : l.menuList[0];
      F(r, r == null ? void 0 : r.nodes[0]);
    }
  }
  const we = (a) => {
    j.value = a;
  };
  function F(a, e) {
    var n;
    e && (e != null && e.isLeaf || (a == null || a.panel.expandNode(e, true), (n = e == null ? void 0 : e.children[0]) != null && n.isLeaf || F(a, e == null ? void 0 : e.children[0])));
  }
  function ke(a, e, n, s) {
    var u, b;
    const l = (u = s == null ? void 0 : s.panel) == null ? void 0 : u.menuList[0], r = l == null ? void 0 : l.panel.expandingNode;
    (b = r == null ? void 0 : r.children[0]) != null && b.isLeaf || F(l, r == null ? void 0 : r.children[0]);
  }
  const xe = { needSchedulingQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: mt, message: "数量必须大于0", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, Te = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: Ce, cleanUpData: qe, wrongCellMask: Se } = dt({ rules: xe, ditto: Te });
  J.HOOK.beforeToQuery = () => {
    Q(), z();
  }, J.HOOK.handleRefresh = (a, e) => {
    var s;
    e.data.content = e.data.content.map((l, r) => {
      var u, b;
      return l.needSchedulingQuantity = l.unSchedulingQuantity, l.factoryId = (b = R.value[(u = l.area) == null ? void 0 : u.id]) == null ? void 0 : b.factoryId, l.orderIndex = r + 1, r > 0 && (l.askCompleteTime = "同上", l.groupsId = "同上"), l.rowKey = r + "" + Math.random(), l;
    }), !a.query.monomerId && !a.query.name && !a.query.areaId && !a.query.specification && !a.query.material && !a.query.serialNumber && ((s = L.value) == null || s.getNameOption(e.data.content));
    const n = P.value.findIndex((l) => {
      var r;
      return l.id === ((r = G.value) == null ? void 0 : r[0]);
    });
    if (n !== -1) {
      const [l] = P.value.splice(n, 1);
      P.value.unshift(l);
    }
  };
  async function Q() {
    var a;
    C.value = { totalNetWeight: 0, quantity: 0 };
    try {
      if (!((a = i.query) != null && a.areaIdList.length)) return;
      C.value = await et(i.query) || {};
    } catch (e) {
      console.log(e, "获取汇总信息");
    }
  }
  function Le(a, e, n) {
    if (n !== 0 && !a && (e.groupsId = "同上"), a) {
      const s = N.value + "_" + a, l = askTime.value[s], r = H().startOf("day").valueOf();
      l >= r && (e.askCompleteTime = l);
    }
  }
  function Ve(a, e, n) {
    n !== 0 && !a && (e.askCompleteTime = "同上");
  }
  function B(a = false) {
    var e;
    a && ((e = L.value) == null || e.refreshTypeList()), Q(), z(), i.toQuery();
  }
  async function z() {
    try {
      if (!i.query.areaIdList.length) return;
      const a = await tt({ areaIdList: i.query.areaIdList });
      D.value = a;
    } catch (a) {
      console.log("获取构件排产记录气泡条数失败", a);
    }
  }
  const Ne = pt(async function(a = []) {
    var r;
    C.value = {}, D.value = 0;
    const e = [], n = {}, s = [], l = [];
    T.value = void 0;
    for (let u = 0; u < a.length; u++) e.push(a[u].id), n[a[u].id] = a[u], s.push(a[u].factoryId), l.push(a[u].workshopId), T.value = T.value ? Math.min(a[u].endDate, T.value) : a[u].endDate;
    i.query.areaIdList = e, i.query.structureClassId = void 0, i.query.artName = void 0, R.value = n, O.value = s, G.value = l, await z(), await Q(), await ((r = L.value) == null ? void 0 : r.refreshTypeList()), i.toQuery();
  }, 500), De = (a) => {
    N.value = a;
  };
  function Pe(a) {
    i.selectionChangeHandler(a), i.selections.sort(function(e, n) {
      return e.orderIndex - n.orderIndex;
    });
  }
  async function Oe() {
    var s;
    if (!((s = i.selections) != null && s.length)) {
      ze.warning("请至少选择一条数据");
      return;
    }
    const a = i.selections.map((l) => l), { validResult: e, dealList: n } = Ce(a);
    if (e) {
      qe(n);
      let l = false;
      if ($.value = n.map((r, u) => (r.askCompleteTime > T.value && (l = true), { ...r, ...be.value[r.groupsId] })), l) {
        try {
          await Me.confirm("排产计划大于排期计划，是否确定？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), V.value = true;
        } catch (r) {
          console.log(r, "取消");
        }
        return;
      }
    } else return e;
    V.value = true;
  }
  function Re() {
    U.value = true;
  }
  async function Ue(a) {
    K.value = await at({ workshopId: a });
  }
  return (a, e) => {
    var ee, te, ae, oe, re, le, ie, ne, se, ue;
    const n = He, s = ce("common-button"), l = Ge, r = Ke, u = $e, b = Ye, je = Je, Ee = ce("common-table"), Z = Fe("permission"), We = Xe;
    return g(), Qe("div", kt, [_("div", xt, [m(t(vt), { heightStyle: t(_e), onGetProjectId: De, onGetWorkShopId: Ue, onIsReal: we, onAreaClick: t(Ne) }, null, 8, ["heightStyle", "onAreaClick"])]), _("div", Tt, [q(m(n, { type: "info", size: "large" }, { default: p(() => e[8] || (e[8] = [I(" * 请先选择区域，进行构件区域排产 ")])), _: 1, __: [8] }, 512), [[fe, !((te = (ee = t(i).query) == null ? void 0 : ee.areaIdList) != null && te.length)]]), q(_("div", null, [_("div", Ct, [m(t(ft), { ref_key: "mHeaderRef", ref: L, projectId: N.value }, { optLeft: p(() => {
      var o, f, d, de, pe, me;
      return [q((g(), y(s, { type: "success", size: "default", onClick: Oe }, { default: p(() => e[9] || (e[9] = [I("预览并保存")])), _: 1, __: [9] })), [[Z, t(S).save]]), t(ge)(t(S).import) ? (g(), y(s, { key: 0, disabled: ((f = (o = t(i).query) == null ? void 0 : o.areaIdList) == null ? void 0 : f.length) !== 1, type: "primary", size: "default", onClick: e[0] || (e[0] = (Lt) => A.value = true) }, { default: p(() => e[10] || (e[10] = [I(" 任务导入 ")])), _: 1, __: [10] }, 8, ["disabled"])) : h("", true), t(ge)(t(S).import) ? (g(), y(st, { key: 1, disabled: ((de = (d = t(i).query) == null ? void 0 : d.areaIdList) == null ? void 0 : de.length) !== 1, fn: t(ot), params: { areaId: (me = (pe = t(i).query) == null ? void 0 : pe.areaIdList) == null ? void 0 : me[0], ...X.value }, style: { "margin-left": "10px" } }, { default: p(() => e[11] || (e[11] = [I(" 任务导入模板下载 ")])), _: 1, __: [11] }, 8, ["disabled", "fn", "params"])) : h("", true)];
    }), viewLeft: p(() => [m(n, { size: "large", effect: "plain", style: { "margin-right": "5px" } }, { default: p(() => [I(" 数量(件)：" + k(C.value.quantity || 0), 1)]), _: 1 }), m(n, { size: "large", effect: "plain", style: { "margin-right": "10px" } }, { default: p(() => {
      var o;
      return [I(" 重量(kg)：" + k(((o = C.value.totalNetWeight) == null ? void 0 : o.toFixed(2)) || 0), 1)];
    }), _: 1 }), m(l, { value: D.value, max: 99, hidden: D.value < 1, style: { "margin-right": "20px" } }, { default: p(() => [q((g(), y(s, { type: "primary", size: "default", onClick: Re }, { default: p(() => e[12] || (e[12] = [I(" 构件排产记录 ")])), _: 1, __: [12] })), [[Z, t(S).recordGet]])]), _: 1 }, 8, ["value", "hidden"])]), _: 1 }, 8, ["projectId"])]), q((g(), y(Ee, { ref_key: "tableRef", ref: Y, "cell-class-name": t(Se), data: t(i).data, "empty-text": t(i).emptyText, "max-height": t(ve) - 30, "row-key": "rowKey", style: { width: "100%" }, onSelectionChange: Pe }, { default: p(() => [m(r, { type: "selection", width: "55", align: "center", fixed: "left" }), t(v).visible("monomer") ? (g(), y(r, { key: 0, "show-overflow-tooltip": true, align: "center", fixed: "left", label: "单体/区域", prop: "monomer", width: "200px" }, { default: p(({ row: o }) => [_("span", null, k(`${o.monomer.name} / ${o.area.name}`), 1)]), _: 1 })) : h("", true), m(t(bt), { columns: t(v), productType: t(x), snClickable: "", onDrawingPreview: t(ye) }, null, 8, ["columns", "productType", "onDrawingPreview"]), t(v).visible("length") ? (g(), y(r, { key: 1, "show-overflow-tooltip": true, prop: "length", label: "长度(mm)", "min-width": "80px", align: "center" }, { default: p(({ row: o }) => [_("span", null, k(o.length), 1)]), _: 1 })) : h("", true), t(v).visible("grossWeight") ? (g(), y(r, { key: 2, "show-overflow-tooltip": true, prop: "grossWeight", label: "单毛重(kg)", "min-width": "80px", align: "center" }, { default: p(({ row: o }) => [_("span", null, k(o.grossWeight), 1)]), _: 1 })) : h("", true), t(v).visible("netWeight") ? (g(), y(r, { key: 3, label: "单净重(kg)", "show-overflow-tooltip": true, align: "center", "min-width": "80px", prop: "netWeight" }, { default: p(({ row: o }) => [_("span", null, k(o.netWeight), 1)]), _: 1 })) : h("", true), t(v).visible("needSchedulingQuantity") ? (g(), y(r, { key: 4, "show-overflow-tooltip": true, align: "center", label: "数量", prop: "needSchedulingQuantity", width: "80px" }, { default: p(({ row: { sourceRow: o } }) => [m(u, { modelValue: o.needSchedulingQuantity, "onUpdate:modelValue": (f) => o.needSchedulingQuantity = f, step: 1, min: 1, max: o.unSchedulingQuantity, precision: 0, size: "default", controls: false, style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 })) : h("", true), t(v).visible("groupsId") ? (g(), y(r, { key: 5, "show-overflow-tooltip": true, align: "center", label: "生产线", "min-width": "150px", prop: "groupsId" }, { default: p(({ row: { sourceRow: o }, $index: f }) => [m(b, { ref: (d) => W.value[f] = d, modelValue: o.groupsId, "onUpdate:modelValue": (d) => o.groupsId = d, options: t(P), placeholder: f === 0 ? "请选择生产线" : "同上", props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", onChange: (d) => Le(d, o, f), onFocus: (d) => Ie(d, o, f, W.value[f]), onExpandChange: (d) => ke(d, o, f, W.value[f]) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange", "onFocus", "onExpandChange"])]), _: 1 })) : h("", true), t(v).visible("askCompleteTime") ? (g(), y(r, { key: 6, align: "center", label: "要求完成日期", "min-width": "130px", prop: "askCompleteTime" }, { default: p(({ row: { sourceRow: o }, $index: f }) => [m(je, { modelValue: o.askCompleteTime, "onUpdate:modelValue": (d) => o.askCompleteTime = d, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (d) => t(H)(d).valueOf() < t(H)().subtract(1, "days").valueOf(), placeholder: f === 0 ? "需求完成日期" : "同上", onChange: (d) => Ve(d, o, f) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["cell-class-name", "data", "empty-text", "max-height"])), [[We, t(i).loading]]), m(t(ut))], 512), [[fe, (oe = (ae = t(i).query) == null ? void 0 : ae.areaIdList) == null ? void 0 : oe.length]]), m(t(wt), { visible: t(E), "onUpdate:visible": e[1] || (e[1] = (o) => Be(E) ? E.value = o : null), "area-id": t(i).query.areaId, "bool-bim": (re = t(w)) == null ? void 0 : re.boolBim, drawingSN: (le = t(w)) == null ? void 0 : le.drawingSN, "monomer-id": (ie = t(w)) == null ? void 0 : ie.monomerId, productId: (ne = t(w)) == null ? void 0 : ne.productId, productType: (se = t(w)) == null ? void 0 : se.productType, "serial-number": (ue = t(w)) == null ? void 0 : ue.serialNumber }, null, 8, ["visible", "area-id", "bool-bim", "drawingSN", "monomer-id", "productId", "productType", "serial-number"]), m(t(gt), { visible: V.value, "onUpdate:visible": e[2] || (e[2] = (o) => V.value = o), productType: t(x), list: $.value, onSuccess: B }, null, 8, ["visible", "productType", "list"]), m(t(ht), { visible: U.value, "onUpdate:visible": e[3] || (e[3] = (o) => U.value = o), monomerDetail: t(i).data[0], "other-query": { areaIdList: t(i).query.areaIdList }, projectId: N.value, onRefresh: e[4] || (e[4] = (o) => B(true)) }, null, 8, ["visible", "monomerDetail", "other-query", "projectId"]), m(t(yt), { visible: A.value, "onUpdate:visible": e[5] || (e[5] = (o) => A.value = o), productType: t(x), query: t(i).query, onSuccess: e[6] || (e[6] = (o) => B(true)) }, null, 8, ["visible", "productType", "query"]), m(t(_t), { modelValue: j.value, "onUpdate:modelValue": e[7] || (e[7] = (o) => j.value = o), lineNameList: K.value }, null, 8, ["modelValue", "lineNameList"])])]);
  };
} }, na = rt(qt, [["__scopeId", "data-v-38969c59"]]);
export {
  na as default
};
