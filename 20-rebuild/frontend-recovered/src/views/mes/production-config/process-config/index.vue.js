import { ref as E } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as u } from "vue";
import { unref as e } from "vue";
import { withDirectives as M } from "vue";
import { createBlock as a } from "vue";
import { withCtx as r } from "vue";
import { toDisplayString as p } from "vue";
import { createCommentVNode as l } from "vue";
import { withModifiers as B } from "vue";
import { ElMessageBox as V } from "element-plus";
import { ElNotification as D } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { vLoading as S } from "element-plus";
import { c as h } from "../../../../modules/process-config-df49251e.js";
import { x as A, oY as m, o as L, oS as R, oZ as $, o_ as q, cf as H, G as g } from "../../../../shared/runtime.js";
import z from "./module/header.vue.js";
import G from "./module/form.vue.js";
const I = { class: "app-container" }, Q = { class: "head-container" }, K = { __name: "index", setup(U) {
  const b = { add: true, edit: false, del: false, download: false }, y = E(), { crud: s, columns: c } = A({ title: "工序配置", sort: [], optShow: { ...b }, dataPath: "", permission: { ...m }, hasPagination: false, crudApi: { ...h } }, y), { maxHeight: x } = L({ paginate: false });
  async function v(f) {
    try {
      V.confirm("是否确认删除该工序？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
        await h.del({ ids: [f.id] }), D({ title: "删除成功", type: "success", duration: 2500 }), s.toQuery();
      }).catch((d) => {
        console.log(d, "删除失败");
      });
    } catch (d) {
      console.log(d);
    }
  }
  return (f, d) => {
    const n = N, _ = w("common-button"), k = w("common-table"), C = S;
    return o(), P("div", I, [i("div", Q, [u(e(z))]), M((o(), a(k, { ref_key: "tableRef", ref: y, "return-source-data": "", data: e(s).data, "empty-text": e(s).emptyText, "max-height": e(x), showEmptySymbol: false, style: { width: "100%" } }, { default: r(() => [u(n, { label: "序号", type: "index", align: "center", width: "60" }), e(c).visible("productCategoryType") ? (o(), a(n, { key: "productCategoryType", prop: "productCategoryType", "show-overflow-tooltip": true, label: "类型", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(e(R).VL[t.row.productCategoryType] || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("partProdMode") && e(s).query.productType === e($).MACHINE_PART.V ? (o(), a(n, { key: "partProdMode", prop: "partProdMode", "show-overflow-tooltip": true, label: "生产方式", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(e(q).VL[t.row.partProdMode] || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("type") ? (o(), a(n, { key: "type", prop: "type", "show-overflow-tooltip": true, label: "工序类", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(e(H).VL[t.row.type] || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("name") ? (o(), a(n, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "工序名称", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(t.row.name || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("codename") ? (o(), a(n, { key: "codename", prop: "codename", "show-overflow-tooltip": true, label: "代号", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(t.row.codename || "-"), 1)]), _: 1 })) : l("", true), e(c).visible("sort") ? (o(), a(n, { key: "sort", prop: "sort", "show-overflow-tooltip": true, label: "排序", "min-width": "140px", align: "center" }, { default: r((t) => [i("span", null, p(t.row.sort || "-"), 1)]), _: 1 })) : l("", true), u(n, { label: "操作", align: "center" }, { default: r((t) => [e(g)(e(m).edit) ? (o(), a(_, { key: 0, type: "primary", icon: "el-icon-edit", size: "default", onClick: B((T) => e(s).toEdit(t.row), ["stop"]) }, null, 8, ["onClick"])) : l("", true), e(g)(e(m).del) ? (o(), a(_, { key: 1, type: "danger", icon: "el-icon-delete", size: "default", onClick: (T) => v(t.row) }, null, 8, ["onClick"])) : l("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[C, e(s).loading]]), u(e(G))]);
  };
} };
export {
  K as default
};
