import { ref as m } from "vue";
import T from "moment";
import { resolveComponent as U } from "vue";
import { resolveDirective as oe } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as x } from "vue";
import { createVNode as _ } from "vue";
import { unref as a } from "vue";
import { createBlock as n } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as I } from "vue";
import { Fragment as ae } from "vue";
import { withDirectives as M } from "vue";
import { createCommentVNode as f } from "vue";
import { toDisplayString as P } from "vue";
import { ElMessage as S } from "element-plus";
import { ElTag as se } from "element-plus";
import { ElTableColumn as le } from "element-plus";
import { ElCascader as ne } from "element-plus";
import { ElDatePicker as ie } from "element-plus";
import { vLoading as re } from "element-plus";
import { f as ue } from "../../../../../modules/machine-part-b1b959c2.js";
import { _ as ce, x as de, o as pe, F as me, aw as fe, V as ge } from "../../../../../shared/runtime.js";
import { D as q } from "../../../../../modules/bridge-86f96a4f.js";
import { m as he } from "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import _e from "./module/header.vue.js";
import be from "./module/nesting-task-list.vue.js";
import ye from "./module/preview-dialog.vue.js";
import "../../../../../modules/box-3fab54f9.js";
import "../../../../../modules/common-8949b382.js";
const ke = { class: "app-container wrap" }, we = { class: "wrap-left" }, Ce = { class: "wrap-right" }, ve = { class: "head-container" }, Te = { key: 1 }, xe = { key: 1 }, Ie = { __name: "index", setup(Ne) {
  const H = { add: false, edit: false, del: false, download: false }, N = m(), { crud: i, columns: p, CRUD: V } = de({ title: "套料成果", sort: [], permission: { ...q }, optShow: { ...H }, crudApi: { get: ue }, queryOnPresenterCreated: false, dataPath: "", hasPagination: false, requiredQuery: ["id"] }, N), { maxHeight: E } = pe({ paginate: false }), b = m(), D = m(false), k = m({ list: [], obj: {} });
  async function O() {
    if (!D.value) try {
      k.value = await he({ productType: me.MACHINE_PART.V }), D.value = true;
    } catch (e) {
      console.log("获取生产组的信息失败", e);
    }
  }
  const B = { groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择需求完成日期", trigger: "change" }] }, Y = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: z, cleanUpData: A, wrongCellMask: F } = fe({ rules: B, ditto: Y });
  V.HOOK.beforeRefresh = async () => {
    await O();
  }, V.HOOK.handleRefresh = (e, t) => {
    t.data = t.data.map((o, r) => (r > 0 && !o.boolIssueEnum && (o.askCompleteTime = "同上", o.groupsId = "同上"), o.boolIssueEnum && (o.askCompleteTime = T(o.askCompleteTime).format("YYYY-MM-DD")), o.rowKey = r + "" + Math.random(), o.spec = `${o.thick}*${o.width}*${o.length}`, o));
  };
  function G(e, t, o) {
    o !== 0 && !e && (t.groupsId = "同上");
  }
  function K(e, t, o) {
    o !== 0 && !e && (t.askCompleteTime = "同上");
  }
  function L(e) {
    e.pdfUrl ? window.open(e.pdfUrl) : S.error("文档不存在");
  }
  function $(e, t) {
    return !e.boolIssueEnum;
  }
  const g = m(), w = m(false), C = m([]);
  function j(e, t) {
    g.value = e, i.query.id = e == null ? void 0 : e.id, e != null && e.id && i.toQuery();
  }
  async function Q() {
    var t;
    i.data = [];
    const e = ge(g.value);
    await ((t = b == null ? void 0 : b.value) == null ? void 0 : t.refresh(e));
  }
  function J() {
    if (!i.selections) {
      S.warning("请至少选择一条数据");
      return;
    }
    C.value = [];
    const e = i.selections.map((r) => r), { validResult: t, dealList: o } = z(e);
    t && (A(o), C.value = o.map((r) => ({ ...r, ...k.value.obj[r.groupsId] })), w.value = true);
  }
  return (e, t) => {
    var R;
    const o = se, r = U("common-button"), u = le, W = ne, X = ie, Z = U("common-table"), ee = oe("permission"), te = re;
    return l(), y("div", ke, [x("div", we, [_(be, { ref_key: "nestingTaskRef", ref: b, maxHeight: a(E), onNestingTaskClick: j }, null, 8, ["maxHeight"])]), x("div", Ce, [(R = a(i).query) != null && R.id ? (l(), y(ae, { key: 1 }, [x("div", ve, [_(a(_e), null, { optRight: d(() => {
      var s;
      return [M((l(), n(r, { class: "filter-item", disabled: !((s = a(i).selections) != null && s.length), size: "default", icon: "el-icon-edit", type: "primary", onClick: J }, { default: d(() => t[2] || (t[2] = [I(" 任务下发 ")])), _: 1, __: [2] }, 8, ["disabled"])), [[ee, a(q).save]])];
    }), _: 1 })]), M((l(), n(Z, { ref_key: "tableRef", ref: N, data: a(i).data, "empty-text": a(i).emptyText, "max-height": a(E), "cell-class-name": a(F), "row-key": "rowKey", style: { width: "100%" }, onSelectionChange: a(i).selectionChangeHandler }, { default: d(() => [_(u, { type: "selection", width: "55", align: "center", class: "selection", selectable: $ }), _(u, { label: "序号", type: "index", align: "center", width: "60" }), a(p).visible("cutNumber") ? (l(), n(u, { key: 0, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "160", align: "center" })) : f("", true), a(p).visible("spec") && g.value.boolNestCutEnum ? (l(), n(u, { key: 1, prop: "spec", "show-overflow-tooltip": true, label: "原材料规格", "min-width": "120", align: "center" })) : f("", true), a(p).visible("num") && g.value.boolNestCutEnum ? (l(), n(u, { key: 2, prop: "num", "show-overflow-tooltip": true, label: "板材数量(件)", width: "100", align: "center" })) : f("", true), a(p).visible("orderNumber") && g.value.boolNestCutEnum ? (l(), n(u, { key: 3, prop: "orderNumber", "show-overflow-tooltip": true, label: "套料文档", width: "100", align: "center" }, { default: d(({ row: s }) => [_(r, { size: "default", type: "primary", onClick: (h) => L(s) }, { default: d(() => t[3] || (t[3] = [I("查看")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })) : f("", true), a(p).visible("cutName") ? (l(), n(u, { key: 4, prop: "cutName", "show-overflow-tooltip": true, label: "切割方式", width: "100", align: "center" })) : f("", true), a(p).visible("groupsId") ? (l(), n(u, { key: 5, "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: d(({ row: { sourceRow: s }, $index: h }) => {
      var c;
      return [s.boolIssueEnum ? (l(), y("span", Te, P((c = s.groups) == null ? void 0 : c.name), 1)) : (l(), n(W, { key: 0, modelValue: s.groupsId, "onUpdate:modelValue": (v) => s.groupsId = v, options: k.value.list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, filterable: "", clearable: "", placeholder: h === 0 ? "请选择生产组" : "同上", onChange: (v) => G(v, s, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"]))];
    }), _: 1 })) : f("", true), a(p).visible("askCompleteTime") ? (l(), n(u, { key: 6, prop: "askCompleteTime", label: "要求完成日期", align: "center", "min-width": "130px" }, { default: d(({ row: { sourceRow: s }, $index: h }) => [s.boolIssueEnum ? (l(), y("span", xe, P(s.askCompleteTime), 1)) : (l(), n(X, { key: 0, modelValue: s.askCompleteTime, "onUpdate:modelValue": (c) => s.askCompleteTime = c, type: "date", size: "default", "value-format": "x", style: { width: "100%" }, disabledDate: (c) => a(T)(c).valueOf() < a(T)().subtract(1, "days").valueOf(), placeholder: h === 0 ? "需求完成日期" : "同上", onChange: (c) => K(c, s, h) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabledDate", "placeholder", "onChange"]))]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "cell-class-name", "onSelectionChange"])), [[te, a(i).loading]])], 64)) : (l(), n(o, { key: 0, type: "info", size: "large" }, { default: d(() => t[1] || (t[1] = [I(" * 请先选择套料任务，进行零件任务下发 ")])), _: 1, __: [1] })), _(a(ye), { visible: w.value, "onUpdate:visible": t[0] || (t[0] = (s) => w.value = s), list: C.value, info: g.value, onSuccess: Q }, null, 8, ["visible", "list", "info"])])]);
  };
} }, Oe = ce(Ie, [["__scopeId", "data-v-6e45fb95"]]);
export {
  Oe as default
};
