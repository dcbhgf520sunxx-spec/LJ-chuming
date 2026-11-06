import { useStore as M } from "vuex";
import { ref as S } from "vue";
import { inject as z } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as i } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as l } from "vue";
import { toDisplayString as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createTextVNode as b } from "vue";
import { createVNode as s } from "vue";
import { createElementBlock as Q } from "vue";
import { Fragment as X } from "vue";
import { createCommentVNode as f } from "vue";
import { ElMessageBox as Y } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { InfoFilled as W } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { ElSwitch as te } from "element-plus";
import { ElCard as oe } from "element-plus";
import { vLoading as ae } from "element-plus";
import { c as ne, m as le, e as ie } from "./module/form.vue.js";
import { _ as se, x as re, aQ as g, aR as de, aD as T, G as R, aS as _, an as ce, P as ue } from "../../../../../shared/runtime.js";
import me from "./module/header.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
const pe = { style: { "line-height": "28px" } }, fe = { class: "head-container" }, _e = { style: { "margin-right": "20px" } }, be = { style: { display: "inline-block" } }, ge = { __name: "index", emits: ["click-line"], setup(ye, { emit: v }) {
  const V = M(), D = v, N = { add: false, edit: false, del: false, download: false }, P = S(), { crud: u, columns: y, CRUD: h } = re({ title: "生产线", sort: [], permission: { ...g }, optShow: { ...N }, crudApi: { ...ne }, invisibleColumns: ["shortName", "factoryName", "workshopName"] }, P), w = S([]), F = S([["targetProductionShow", ["to-fixed", 2]]]), B = z("maxHeight");
  async function U(r, o) {
    try {
      await Y.confirm('此操作将 "' + _.VL[o] + '" ' + r.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ie({ id: r.id, boolEnabledEnum: o }), u.refresh(), u.notify(_.VL[o] + "成功", h.NOTIFICATION_TYPE.SUCCESS), k();
    } catch (a) {
      console.log("变更生产线状态", a), r.boolEnabledEnum = r.boolEnabledEnum === _.TRUE.V ? _.FALSE.V : _.TRUE.V;
    }
  }
  function A(r) {
    r && D("click-line", r);
  }
  h.HOOK.handleRefresh = (r, { data: o }) => {
    o.content.forEach((a) => {
      var d, x, E;
      a.targetProductionShow = a.targetProduction && a.targetProduction / 1e3 || 0, a.typeSequence = (x = (d = a == null ? void 0 : a.typeList) == null ? void 0 : d.map((m) => `【${m == null ? void 0 : m.name}】`)) == null ? void 0 : x.join(""), a.linkIdList = ((E = a == null ? void 0 : a.typeList) == null ? void 0 : E.map((m) => m.id)) || [];
    });
  }, h.HOOK.afterSubmit = () => {
    k();
  }, h.HOOK.afterDelete = () => {
    k();
  };
  function k() {
    V.commit("config/SET_LOADED", { key: "bridgeProductLines", loaded: false }), V.commit("config/SET_LOADED", { key: "bridgeOnlyProductLines", loaded: false });
  }
  return (r, o) => {
    const a = C("common-button"), d = J, x = C("table-cell-tag"), E = W, m = Z, I = ee, H = te, K = C("common-table"), $ = oe, j = G("permission"), q = ae;
    return i(), c($, { class: "line-box box-card" }, { header: n(() => [l("span", pe, p(e(u).title) + "列表", 1), O((i(), c(a, { style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(u).toAdd }, { default: n(() => o[1] || (o[1] = [b(" 新增 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[j, e(g).add]])]), default: n(() => [l("div", fe, [s(e(me))]), O((i(), c(K, { ref_key: "tableRef", ref: P, "highlight-current-row": "", data: e(u).data, "empty-text": e(u).emptyText, "data-format": F.value, "max-height": e(B), "default-expand-all": false, "expand-row-keys": w.value, "row-key": "id", style: { width: "100%" }, onCurrentChange: A }, { default: n(() => [s(de, { data: e(u).data, "expand-row-keys": w.value, "onUpdate:expandRowKeys": o[0] || (o[0] = (t) => w.value = t), "row-key": "id", fixed: "left" }, { default: n(({ row: { sourceRow: t } }) => [l("p", null, [o[2] || (o[2] = b(" 工厂：")), l("span", _e, p(t.factoryName), 1), o[3] || (o[3] = b(" 车间：")), l("span", null, p(t.workshopName), 1)]), t.productType & e(T).BOX.V ? (i(), Q(X, { key: 0 }, [o[4] || (o[4] = b(" 可生产类型：")), l("span", null, p(t.typeSequence), 1)], 64)) : f("", true), l("p", null, [o[5] || (o[5] = b(" 备注：")), l("span", null, p(t.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), s(d, { label: "序号", type: "index", align: "center", width: "60" }), e(y).visible("name") ? (i(), c(d, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "生产线名称", "min-width": "140px" }, { default: n(({ row: t }) => [t.productType ? (i(), c(x, { key: 0, name: e(T).V[t.productType].SL, color: e(T).V[t.productType].COLOR, offset: 15 }, null, 8, ["name", "color"])) : f("", true), l("span", null, p(t.name), 1)]), _: 1 })) : f("", true), e(y).visible("targetProductionShow") ? (i(), c(d, { key: "targetProductionShow", prop: "targetProductionShow", "show-overflow-tooltip": true, label: "目标产量(吨/月)", align: "center", width: "110px" }, { default: n(({ row: t }) => [l("span", null, p(t.targetProductionShow), 1)]), _: 1 })) : f("", true), e(y).visible("boolEnabledEnum") ? (i(), c(d, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center", width: "80px" }, { header: n(() => [s(I, { class: "item", effect: "light", content: "生产线被禁用后，该生产线无法再在其它页面中显示", placement: "top" }, { default: n(() => [l("div", be, [o[6] || (o[6] = l("span", null, "状态", -1)), s(m, null, { default: n(() => [s(E)]), _: 1 })])]), _: 1 })]), default: n((t) => [s(H, { modelValue: t.row.boolEnabledEnum, "onUpdate:modelValue": (L) => t.row.boolEnabledEnum = L, disabled: !e(R)(e(g).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(_).TRUE.V, "inactive-value": e(_).FALSE.V, onChange: (L) => U(t.row, t.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : f("", true), e(y).visible("sort") ? (i(), c(d, { key: "sort", prop: "sort", label: "排序", align: "center", width: "80px" })) : f("", true), e(R)([...e(g).del, ...e(g).edit]) ? (i(), c(d, { key: 4, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: n((t) => [s(e(ce), { data: t.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "expand-row-keys"])), [[q, e(u).loading]]), s(e(ue)), s(e(le))]), _: 1 });
  };
} }, Se = se(ge, [["__scopeId", "data-v-97b9f695"]]);
export {
  Se as default
};
