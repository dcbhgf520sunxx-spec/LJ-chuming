import { ref as F } from "vue";
import { computed as N } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as E } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as n } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as R } from "vue";
import { createCommentVNode as i } from "vue";
import { withModifiers as k } from "vue";
import { ElMessageBox as L } from "element-plus";
import { ElMessage as U } from "element-plus";
import { ElTableColumn as $ } from "element-plus";
import { vLoading as H } from "element-plus";
import { l as m, x as S, s8 as h, o as V, D as x, G as y, P as z } from "../../../../shared/runtime.js";
import O from "./module/header.vue.js";
import Y from "./module/form.vue.js";
function j(o) {
  return m({ module: "mes", url: "wage-quota-management/painting-quota-config/page", method: "get", params: o });
}
function G(o) {
  return m({ module: "mes", url: "wage-quota-management/painting-quota-config", method: "post", data: o });
}
function K(o) {
  return m({ module: "mes", url: "wage-quota-management/painting-quota-config", method: "put", data: o });
}
function Q(o) {
  return m({ module: "mes", url: "wage-quota-management/painting-quota-config", method: "delete", params: o });
}
const b = { get: j, add: G, edit: K, del: Q }, I = { class: "app-container" }, J = { class: "head-container" }, te = { __name: "index", setup(o) {
  const v = { add: true, edit: false, del: false, download: false }, g = F(), { crud: s, columns: r, CRUD: P } = S({ title: "油漆定额", permission: { ...h }, optShow: { ...v }, crudApi: { ...b }, hasPagination: true }, g), { maxHeight: C } = V({ paginate: true });
  P.HOOK.handleRefresh = (u, l) => {
    l.data.content = l.data.content.map((t) => (t.workshopNameList = t.workshopNameList.join(), t));
  };
  const A = N(() => [["startAddPrice", ["to-thousand", x.YUAN]], ["startPrice", ["to-thousand", x.YUAN]]]);
  async function B(u) {
    try {
      await L.confirm("确认删除该配置？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await b.del({ id: u.id }), U.success("删除成功！"), s.refresh();
    } catch (l) {
      console.log(l);
    }
  }
  return (u, l) => {
    const t = $, f = w("common-button"), T = w("common-table"), q = H;
    return a(), E("div", I, [_("div", J, [c(e(O))]), M((a(), n(T, { ref_key: "tableRef", ref: g, data: e(s).data, "empty-text": e(s).emptyText, "data-format": A.value, "max-height": e(C), style: { width: "100%" } }, { default: p(() => [c(t, { label: "序号", type: "index", align: "center", width: "60" }), e(r).visible("type") ? (a(), n(t, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "适用车间", align: "center", "min-width": "100px" }, { default: p((d) => [_("span", null, R(d.row.workshopNameList || "-"), 1)]), _: 1 })) : i("", true), e(r).visible("paintFilmThicknessBase") ? (a(), n(t, { key: "paintFilmThicknessBase", prop: "paintFilmThicknessBase", "show-overflow-tooltip": true, label: "漆膜厚度基数(µm)", align: "center", "min-width": "100px" })) : i("", true), e(r).visible("startPrice") ? (a(), n(t, { key: "startPrice", prop: "startPrice", "show-overflow-tooltip": true, label: "	起步单价(元)", align: "center", "min-width": "100px" })) : i("", true), e(r).visible("startAddPaintFilmThickness") ? (a(), n(t, { key: "startAddPaintFilmThickness", prop: "startAddPaintFilmThickness", "show-overflow-tooltip": true, label: "起加漆膜厚度(µm)", align: "center", "min-width": "100px" })) : i("", true), e(r).visible("startAddPrice") ? (a(), n(t, { key: "startAddPrice", prop: "startAddPrice", "show-overflow-tooltip": true, label: "	起加单价(元)", align: "center", "min-width": "100px" })) : i("", true), c(t, { label: "操作", width: "130px", align: "center", fixed: "right" }, { default: p((d) => [e(y)(e(h).edit) ? (a(), n(f, { key: 0, icon: "el-icon-edit", size: "default", type: "primary", onClick: k((D) => e(s).toEdit(d.row), ["stop"]) }, null, 8, ["onClick"])) : i("", true), e(y)(e(h).del) ? (a(), n(f, { key: 1, icon: "el-icon-delete", size: "default", type: "danger", onClick: k((D) => B(d.row), ["stop"]) }, null, 8, ["onClick"])) : i("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height"])), [[q, e(s).loading]]), c(e(z)), c(e(Y))]);
  };
} };
export {
  te as default
};
