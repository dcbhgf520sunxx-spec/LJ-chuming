import { ref as o } from "vue";
import { inject as B } from "vue";
import { resolveComponent as u } from "vue";
import { openBlock as l } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as C } from "vue";
import { unref as i } from "vue";
import { createBlock as f } from "vue";
import { withCtx as b } from "vue";
import { createVNode as e } from "vue";
import { ElTableColumn as D } from "element-plus";
import { vLoading as T } from "element-plus";
import { x as H, D as U, o as V, P as N } from "../../../../../../shared/runtime.js";
import { l as P } from "../../../../../../modules/index-dfff0f60.js";
import A from "../../../../../contract/standing-book/common/components/record/file-download.vue.js";
const R = { key: 1 }, $ = { __name: "pre-settle", setup(q) {
  const m = o(), { table_item_data: g } = B("common"), { crud: a } = H({ title: "预结算记录", crudApi: { get: P } }, m);
  a.query.id = g.value.id;
  const h = o([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["auditTime", ["parse-time", "{y}-{m}-{d}"]], ["amount", ["to-thousand", U.YUAN]]]), { maxHeight: x } = V({ mainBox: ".detail-record", extraBox: [".el-drawer__header", ".header-container", ".box-container"], wrapperBox: ".table-container", navbar: false, paginate: true, minHeight: 300, clientHRepMainH: true }, a.data), r = o(false), c = o([]);
  function v(s) {
    c.value = s.attachments, r.value = true;
  }
  return (s, p) => {
    const t = D, y = u("common-button"), k = u("common-table"), w = T;
    return l(), _("div", null, [C((l(), f(k, { ref_key: "table_ref", ref: m, data: i(a).data, "data-format": h.value, "empty-text": i(a).emptyText, "max-height": i(x) }, { default: b(() => [e(t, { align: "center", label: "序号", type: "index" }), e(t, { align: "center", label: "创建时间", prop: "createTime", width: "100" }), e(t, { align: "center", label: "结算金额", prop: "amount" }), e(t, { align: "center", label: "申请人", prop: "applyUserName" }), e(t, { align: "center", label: "审核人", prop: "auditUserName" }), e(t, { align: "center", label: "审核时间", prop: "auditTime" }), e(t, { align: "center", label: "附件", prop: "attachment", width: "80" }, { default: b(({ row: n }) => {
      var d;
      return [(d = n.attachments) != null && d.length ? (l(), f(y, { key: 0, icon: "el-icon-view", type: "primary", size: "default", onClick: (E) => v(n) }, null, 8, ["onClick"])) : (l(), _("span", R, "-"))];
    }), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[w, i(a).loading]]), e(N), e(A, { "file-list": c.value, modelValue: r.value, "onUpdate:modelValue": p[0] || (p[0] = (n) => r.value = n) }, null, 8, ["file-list", "modelValue"])]);
  };
} };
export {
  $ as default
};
