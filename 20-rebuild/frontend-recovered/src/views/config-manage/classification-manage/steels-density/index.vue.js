import { ref as r } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as F } from "vue";
import { createElementVNode as k } from "vue";
import { createVNode as c } from "vue";
import { withDirectives as M } from "vue";
import { unref as e } from "vue";
import { createBlock as a } from "vue";
import { withCtx as u } from "vue";
import { toDisplayString as V } from "vue";
import { createCommentVNode as i } from "vue";
import { Fragment as L } from "vue";
import { ElMessage as P } from "element-plus";
import { ElTableColumn as H } from "element-plus";
import { ElPopconfirm as U } from "element-plus";
import { vLoading as $ } from "element-plus";
import { da as z, x as A, db as d, dc as Q, o as q, G as h, dd as G } from "../../../../shared/runtime.js";
import j from "./module/header.vue.js";
import I from "./module/form.vue.js";
import J from "./module/edit-form.vue.js";
import "../../../../modules/use-table-operate-4f84437f.js";
const K = { class: "app-container" }, ae = { __name: "index", setup(O) {
  const C = { add: true, edit: false, del: false, download: false }, x = r([...z]), y = r(), { crud: m, columns: s, CRUD: W } = A({ title: "钢材密度配置", sort: ["id.desc"], permission: { ...d }, optShow: { ...C }, crudApi: { ...Q }, invisibleColumns: [], dataPath: "" }, y), { maxHeight: B } = q({ paginate: true }), w = r(false), f = r(false), v = r();
  async function D(p) {
    w.value = true;
    try {
      const l = [];
      l.push(p.id), await G(l).then((o) => {
        o && (P.success("删除成功"), m.toQuery());
      });
    } finally {
      w.value = false;
    }
  }
  function R(p) {
    v.value = p, f.value = true;
  }
  function T() {
    m.toQuery();
  }
  return (p, l) => {
    const o = H, _ = g("common-button"), N = U, S = g("common-table"), E = $;
    return t(), F(L, null, [k("div", K, [c(j), M((t(), a(S, { ref_key: "tableRef", ref: y, data: e(m).data, "data-format": x.value, "max-height": e(B), "highlight-current-row": "" }, { default: u(() => [c(o, { align: "center", label: "序号", type: "index", width: "55" }, { default: u(({ row: n, $index: b }) => [k("span", null, V(b + 1), 1)]), _: 1 }), e(s).visible("basicClass") ? (t(), a(o, { key: "basicClass", label: "材料类型", "min-width": "100", prop: "basicClass", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("classifyName") ? (t(), a(o, { key: "classifyName", label: "科目名称", "min-width": "100", prop: "classifyName", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("density") ? (t(), a(o, { key: "density", label: "密度", "min-width": "120", prop: "density", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("createBy") ? (t(), a(o, { key: "createBy", align: "center", label: "创建人", "min-width": "100", prop: "createBy", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("createTime") ? (t(), a(o, { key: "createTime", align: "center", label: "创建时间", "min-width": "140", prop: "createTime", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("updateBy") ? (t(), a(o, { key: "updateBy", align: "center", label: "最后编辑人", "min-width": "140", prop: "updateBy", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("updateTime") ? (t(), a(o, { key: "updateTime", align: "center", label: "最后编辑时间", "min-width": "140", prop: "updateTime", "show-overflow-tooltip": "" })) : i("", true), e(h)([...e(d).del, ...e(d).edit]) ? (t(), a(o, { key: 7, align: "center", fixed: "right", label: "操作", width: "150" }, { default: u(({ row: { sourceRow: n } }) => [e(h)(e(d).edit) ? (t(), a(_, { key: 0, icon: "el-icon-edit", size: "mini", type: "primary", onClick: (b) => R(n) }, null, 8, ["onClick"])) : i("", true), e(h)(e(d).del) ? (t(), a(N, { key: 1, class: "box-item", placement: "bottom", title: "您确定删除这条配置吗？", onConfirm: (b) => D(n) }, { reference: u(() => [c(_, { icon: "el-icon-delete", size: "mini", type: "danger" })]), _: 2 }, 1032, ["onConfirm"])) : i("", true)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[E, e(m).loading]])]), c(I), c(J, { visible: f.value, "onUpdate:visible": l[0] || (l[0] = (n) => f.value = n), formList: v.value, onSuccess: T }, null, 8, ["visible", "formList"])], 64);
  };
} };
export {
  ae as default
};
