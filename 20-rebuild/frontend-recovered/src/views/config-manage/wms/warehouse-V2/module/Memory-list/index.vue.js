import { useStore as Q } from "vuex";
import { ref as L } from "vue";
import { reactive as Y } from "vue";
import { inject as X } from "vue";
import { computed as O } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as Z } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as A } from "vue";
import { unref as e } from "vue";
import { withDirectives as _ } from "vue";
import { createTextVNode as ee } from "vue";
import { vShow as b } from "vue";
import { createVNode as l } from "vue";
import { createCommentVNode as g } from "vue";
import { ElMessageBox as te } from "element-plus";
import { ElTableColumn as oe } from "element-plus";
import { InfoFilled as ae } from "@element-plus/icons-vue";
import { ElIcon as ne } from "element-plus";
import { ElTooltip as le } from "element-plus";
import { ElSwitch as ie } from "element-plus";
import { ElCard as se } from "element-plus";
import { vLoading as re } from "element-plus";
import { _ as de, hJ as ce, x as pe, hM as me, hN as ue, hO as fe, cP as he, aS as u, G as D, an as _e, P as be, hP as ge } from "../../../../../../shared/runtime.js";
import we from "./module/header.vue.js";
import ye from "./module/form.vue.js";
import xe from "./module/batch-add.vue.js";
import "../../../../../../modules/production-line-c52339bd.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
import "../../../../../../modules/use-add-form-local-storage-75741656.js";
const ke = { style: { "line-height": "28px" } }, Ee = { class: "head-container" }, Se = { style: { display: "inline-block" } }, ve = { __name: "index", props: { workshop: { type: Object, default: () => ({}) } }, emits: ["click-line"], setup(N, { emit: F }) {
  const h = ce.configWmsWorkshopStorageLocationPM, T = Q(), R = F, U = { add: false, edit: false, del: false, download: false }, V = L(), { crud: p, columns: w, CRUD: y } = pe({ title: "存储位置", sort: ["sort.asc"], permission: { ...h }, optShow: { ...U }, crudApi: { get: me, del: ue, edit: fe }, invisibleColumns: ["shortName", "factoryName", "workshopName"], requiredQuery: ["workshopId"] }, V), S = Y({ batchAdd: false }), B = L([]), M = L([["targetProductionShow", ["to-fixed", 2]], ["materialType", ["parse-enum", he, { f: "L", bit: true, split: "、" }]]]), H = X("maxHeight"), v = N, W = O(() => v.workshop), f = O(() => v.workshop && v.workshop.id);
  async function j(i, o) {
    try {
      await te.confirm('此操作将 "' + u.VL[o] + '" ' + i.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ge({ id: i.id, enabled: o }), p.refresh(), p.notify(u.VL[o] + "成功", y.NOTIFICATION_TYPE.SUCCESS), C();
    } catch (t) {
      console.log("变更存储位置状态", t), i.enabled = i.enabled === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  function K(i) {
    i && R("click-line", i);
  }
  y.HOOK.handleRefresh = (i, { data: o }) => {
    o.content.forEach((t) => {
      var s, x, k, E;
      t.targetProductionShow = t.targetProduction && t.targetProduction / 1e3 || 0, t.typeSequence = (x = (s = t == null ? void 0 : t.typeList) == null ? void 0 : s.map((r) => `【${r == null ? void 0 : r.name}】`)) == null ? void 0 : x.join(""), t.linkIdList = ((k = t == null ? void 0 : t.typeList) == null ? void 0 : k.map((r) => r.id)) || [], t.stuffTypeIds = (E = t.stuffTypeIds) == null ? void 0 : E.split(",").map((r) => Number(r));
    });
  }, y.HOOK.afterSubmit = () => {
    C();
  }, y.HOOK.afterDelete = () => {
    C();
  };
  function $() {
    S.batchAdd = true;
  }
  function C() {
    T.commit("config/SET_LOADED", { key: "productLines", loaded: false }), T.commit("config/SET_LOADED", { key: "onlyProductLines", loaded: false });
  }
  return (i, o) => {
    const t = P("common-button"), s = oe, x = ae, k = ne, E = le, r = ie, q = P("common-table"), z = se, G = Z("permission"), J = re;
    return d(), c(z, { class: "line-box box-card" }, { header: n(() => [m("span", ke, A(e(p).title), 1), _((d(), c(t, { icon: "el-icon-plus", size: "default", style: { float: "right", padding: "6px 10px" }, type: "primary", onClick: $ }, { default: n(() => o[2] || (o[2] = [ee(" 新增存储位置 ")])), _: 1, __: [2] })), [[b, f.value], [G, e(h).add]])]), default: n(() => [_(m("div", null, o[3] || (o[3] = [m("div", { class: "my-code" }, "点击仓库查看详情", -1)]), 512), [[b, !f.value]]), _(m("div", Ee, [l(e(we), { workshopId: f.value }, null, 8, ["workshopId"])], 512), [[b, f.value]]), _((d(), c(q, { ref_key: "tableRef", ref: V, data: e(p).data, "data-format": M.value, "default-expand-all": false, "empty-text": e(p).emptyText, "expand-row-keys": B.value, "max-height": e(H), "highlight-current-row": "", "row-key": "id", style: { width: "100%" }, onCurrentChange: K }, { default: n(() => [l(s, { align: "center", label: "序号", type: "index", width: "60" }), e(w).visible("name") ? (d(), c(s, { key: "name", "show-overflow-tooltip": true, label: "存储位置名称", "min-width": "140px", prop: "name" }, { default: n(({ row: a }) => [m("span", null, A(a.name), 1)]), _: 1 })) : g("", true), e(w).visible("materialType") ? (d(), c(s, { key: "materialType", "show-overflow-tooltip": true, align: "center", label: "可存储材料类型", prop: "materialType", width: "200px" })) : g("", true), e(w).visible("boolEnabledEnum") ? (d(), c(s, { key: "boolEnabledEnum", align: "center", label: "状态", prop: "boolEnabledEnum", width: "80px" }, { header: n(() => [l(E, { content: "存储位置被禁用后，该存储位置无法再在其它页面中显示", class: "item", effect: "light", placement: "top" }, { default: n(() => [m("div", Se, [o[4] || (o[4] = m("span", null, "状态", -1)), l(k, null, { default: n(() => [l(x)]), _: 1 })])]), _: 1 })]), default: n((a) => [l(r, { modelValue: a.row.enabled, "onUpdate:modelValue": (I) => a.row.enabled = I, "active-value": e(u).TRUE.V, disabled: !e(D)(e(h).editStatus), "inactive-value": e(u).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (I) => j(a.row, a.row.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : g("", true), e(w).visible("sort") ? (d(), c(s, { key: "sort", align: "center", label: "排序", prop: "sort", width: "80px" })) : g("", true), e(D)([...e(h).del, ...e(h).edit]) ? (d(), c(s, { key: 4, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: n((a) => [l(e(_e), { data: a.row }, null, 8, ["data"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height"])), [[b, f.value], [J, e(p).loading]]), _(l(e(be), null, null, 512), [[b, f.value]]), l(xe, { modelValue: S.batchAdd, "onUpdate:modelValue": o[0] || (o[0] = (a) => S.batchAdd = a), workshop: W.value, onSuccess: o[1] || (o[1] = (a) => e(p).refresh()) }, null, 8, ["modelValue", "workshop"]), l(e(ye))]), _: 1 });
  };
} }, De = de(ve, [["__scopeId", "data-v-5f61223a"]]);
export {
  De as default
};
