import { useStore as $ } from "vuex";
import { ref as L } from "vue";
import { reactive as j } from "vue";
import { inject as q } from "vue";
import { watch as z } from "vue";
import { resolveComponent as D } from "vue";
import { resolveDirective as G } from "vue";
import { openBlock as d } from "vue";
import { createBlock as c } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as m } from "vue";
import { toDisplayString as E } from "vue";
import { unref as t } from "vue";
import { withDirectives as I } from "vue";
import { createTextVNode as J } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as h } from "vue";
import { ElMessageBox as Y } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { InfoFilled as X } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElTooltip as ee } from "element-plus";
import { ElSwitch as te } from "element-plus";
import { ElCard as oe } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as ne, x as se, hJ as b, hK as le, aS as u, G as A, an as ie, P as re, hL as de } from "../../../../../../shared/runtime.js";
import ce from "./module/header.vue.js";
import pe from "./module/form.vue.js";
import me from "./module/batch-add.vue.js";
import "../../../../../../modules/production-line-c52339bd.js";
import "../../../../../../modules/use-table-operate-4f84437f.js";
import "../../../../../../modules/use-add-form-local-storage-75741656.js";
const ue = { style: { "line-height": "28px" } }, he = { class: "head-container" }, fe = { style: { display: "inline-block" } }, _e = { __name: "index", emits: ["click-line", "clearMemoryList"], setup(be, { emit: W }) {
  const N = $(), C = W, R = { add: false, edit: false, del: false, download: false }, O = L(), { crud: p, columns: f, CRUD: _ } = se({ title: "仓库", sort: ["sort.asc"], permission: { ...b }, optShow: { ...R }, crudApi: { ...le }, invisibleColumns: [] }, O), V = j({ batchAdd: false }), F = L([]), P = L([["targetProductionShow", ["to-fixed", 2]]]), v = q("maxHeight");
  async function B(r, n) {
    try {
      await Y.confirm('此操作将 "' + u.VL[n] + '" ' + r.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await de({ id: r.id, enabled: n }), p.refresh(), p.notify(u.VL[n] + "成功", _.NOTIFICATION_TYPE.SUCCESS), U();
    } catch (e) {
      console.log("变更仓库状态", e), r.enabled = r.enabled === u.TRUE.V ? u.FALSE.V : u.TRUE.V;
    }
  }
  function H(r) {
    C("click-line", r);
  }
  _.HOOK.handleRefresh = (r, { data: n }) => {
    n.content.forEach((e) => {
      var l, w, g, k, y, x, S;
      e.targetProductionShow = e.targetProduction && e.targetProduction / 1e3 || 0, e.typeSequence = (w = (l = e == null ? void 0 : e.typeList) == null ? void 0 : l.map((o) => `【${o == null ? void 0 : o.name}】`)) == null ? void 0 : w.join(""), e.linkIdList = ((g = e == null ? void 0 : e.typeList) == null ? void 0 : g.map((o) => o.id)) || [], e.workshopUsers = (k = e.workshopUser) == null ? void 0 : k.split(",").map((o) => Number(o)), e.mesWorkshopId = (y = e.mesWorkshopIds) == null ? void 0 : y.split(",").map((o) => Number(o)), e.workshopUserName = [], (x = e.userSimpleResponseVO) == null || x.forEach((o) => {
        e.workshopUserName.push(o.name);
      }), e.mesWorkshopName = [], (S = e.mesWorkshop) == null || S.forEach((o) => {
        e.mesWorkshopName.push(o.name);
      });
    });
  }, _.HOOK.afterSubmit = () => {
    U();
  }, _.HOOK.afterDelete = () => {
    U();
  }, _.HOOK.afterDelete = () => {
    C("click-line", {});
  };
  function K(r) {
    V.batchAdd = true;
  }
  function U() {
    N.commit("config/SET_LOADED", { key: "productLines", loaded: false }), N.commit("config/SET_LOADED", { key: "onlyProductLines", loaded: false });
  }
  return z(() => p.query, () => {
    C("click-line", {});
  }, { deep: true }), (r, n) => {
    const e = D("common-button"), l = Q, w = X, g = Z, k = ee, y = te, x = D("common-table"), S = oe, o = G("permission"), M = ae;
    return d(), c(S, { class: "line-box box-card" }, { header: s(() => [m("span", ue, E(t(p).title) + "列表", 1), I((d(), c(e, { icon: "el-icon-plus", size: "default", style: { float: "right", padding: "6px 10px" }, type: "primary", onClick: K }, { default: s(() => n[2] || (n[2] = [J(" 新增仓库 ")])), _: 1, __: [2] })), [[o, t(b).add]])]), default: s(() => [m("div", he, [i(t(ce))]), I((d(), c(x, { ref_key: "tableRef", ref: O, data: t(p).data, "data-format": P.value, "default-expand-all": false, "empty-text": t(p).emptyText, "expand-row-keys": F.value, "max-height": t(v), "highlight-current-row": "", "row-key": "id", style: { width: "100%" }, onCurrentChange: H }, { default: s(() => [i(l, { align: "center", label: "序号", type: "index", width: "60" }), t(f).visible("name") ? (d(), c(l, { key: "name", "show-overflow-tooltip": true, label: "仓库名称", "min-width": "100px", prop: "name" }, { default: s(({ row: a }) => [m("span", null, E(a.name), 1)]), _: 1 })) : h("", true), t(f).visible("workshopUser") ? (d(), c(l, { key: "workshopUser", "show-overflow-tooltip": true, align: "center", label: "仓库负责人", prop: "workshopUser", width: "150px" }, { default: s(({ row: a }) => [m("span", null, E(a.workshopUserName.toString() || "-"), 1)]), _: 1 })) : h("", true), t(f).visible("mesWorkshopId") ? (d(), c(l, { key: "mesWorkshopId", "show-overflow-tooltip": true, align: "center", label: "关联MES车间", prop: "mesWorkshopId", width: "150px" }, { default: s(({ row: a }) => [m("span", null, E(a.mesWorkshopName.toString() || "-"), 1)]), _: 1 })) : h("", true), t(f).visible("enabled") ? (d(), c(l, { key: "enabled", align: "center", label: "状态", prop: "enabled", width: "80px" }, { header: s(() => [i(k, { content: "仓库被禁用后，该仓库无法再在其它页面中显示", class: "item", effect: "light", placement: "top" }, { default: s(() => [m("div", fe, [n[3] || (n[3] = m("span", null, "状态", -1)), i(g, null, { default: s(() => [i(w)]), _: 1 })])]), _: 1 })]), default: s((a) => [i(y, { modelValue: a.row.enabled, "onUpdate:modelValue": (T) => a.row.enabled = T, "active-value": t(u).TRUE.V, disabled: !t(A)(t(b).editStatus), "inactive-value": t(u).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (T) => B(a.row, a.row.enabled) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : h("", true), t(f).visible("sort") ? (d(), c(l, { key: "sort", align: "center", label: "排序", prop: "sort", width: "80px" })) : h("", true), t(A)([...t(b).del, ...t(b).edit]) ? (d(), c(l, { key: 5, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: s((a) => [i(t(ie), { data: a.row }, null, 8, ["data"])]), _: 1 })) : h("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height"])), [[M, t(p).loading]]), i(t(re)), i(me, { modelValue: V.batchAdd, "onUpdate:modelValue": n[0] || (n[0] = (a) => V.batchAdd = a), onSuccess: n[1] || (n[1] = (a) => t(p).refresh()) }, null, 8, ["modelValue"]), i(pe)]), _: 1 });
  };
} }, Ve = ne(_e, [["__scopeId", "data-v-c0b9a7f0"]]);
export {
  Ve as default
};
